package cn.edu.cqut.controller;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.util.CrmResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/stats")
@CrossOrigin
public class StatsController {
    private final ICustomerService customerService;

    @Autowired
    public StatsController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public CrmResult<Customer> getCustomers(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            Customer customer,
            String[] date) {
        QueryWrapper<Customer> qw = new QueryWrapper<>();
        String customerName = customer.getCusName();
        if (customerName != null) {
            qw.like("cusName", customerName);
        }
        if (date != null && date.length == 2) {
            qw.between("orderTime", date[0], date[1]);
        }
        Page<Customer> customerPage = new Page<>(page, limit);
        customerService.getTotalTransactionAmount(customerPage, qw);
        CrmResult<Customer> re = new CrmResult<>();
        re.setCode(0);
        re.setMsg("");
        re.setCount(customerPage.getTotal());
        re.setData(customerPage.getRecords());
        return re;
    }

    @RequestMapping(value = "/=", method = RequestMethod.POST)
    public CrmResult<Map.Entry<Customer, Double>> getCustomersWithSalesAmount() {

        CrmResult<Map.Entry<Customer, Double>> re = new CrmResult<>();
        re.setCode(0);
        re.setMsg("");
        re.setCount(0L);
        re.setData(null);
        return re;
    }

    public CrmResult<Customer> getLostCustomerRecords() {

        CrmResult<Customer> re = new CrmResult<>();
        re.setCode(0);
        re.setMsg("");
        re.setCount(0L);
        re.setData(null);
        return re;
    }
}
