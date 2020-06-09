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
            Customer customer) {
        QueryWrapper<Customer> qw = new QueryWrapper<>();
        if (customer.getCusName() != null) {
            qw.like("cusName", customer.getCusName()); //第一个参数是字段名
        }
        Page<Customer> pageCustomer = customerService.page(new Page<>(page, limit), qw);

        CrmResult<Customer> ret = new CrmResult<>();
        ret.setCode(0);
        ret.setMsg("");
        ret.setCount(pageCustomer.getTotal());//表里的记录总数
        ret.setData(pageCustomer.getRecords()); //这页的数据列表
        return ret;
    }

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
