package cn.edu.cqut.controller;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.stats.SimpleCategory;
import cn.edu.cqut.util.CustomResult;
import cn.edu.cqut.util.CrmResult;
import cn.edu.cqut.util.JsonJ;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/stats")
@CrossOrigin
public class StatsController {
    private final ICustomerService customerService;
    public static final int CUSTOMER_COL_RANK = 0;
    public static final int CUSTOMER_COL_CREDIT = 1;
    public static final int CUSTOMER_COL_SATISFACTION = 2;

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

    @RequestMapping(value = "/customer-composition", method = RequestMethod.POST)
    public CustomResult getCustomerComposition(
            @RequestParam(defaultValue = "0") Integer columnCode) {
        String columnName;
        String column;
        switch (columnCode) {
            case CUSTOMER_COL_CREDIT:
                column = "cusCredit";
                columnName = "客户信用度";
                break;
            case CUSTOMER_COL_SATISFACTION:
                column = "cusSatisfied";
                columnName = "客户满意度";
                break;
            case CUSTOMER_COL_RANK: default:
                column = "cusLevel";
                columnName = "客户等级";
                break;
        }
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy(column);
        queryWrapper.select(column + " name", "count(*) count");
        String title = "客户构成：" + columnName;

        List<SimpleCategory> categoryList = customerService.getCustomerComposition(queryWrapper);
        List<Object[]> rows = new ArrayList<>(categoryList.size());
        for (SimpleCategory simpleCategory : categoryList) {
            rows.add(simpleCategory.toArray());
        }

        JsonJ data = new JsonJ();
        data.set("title", title);
        data.set("columnName", columnName);
        data.set("rows", rows);

        CustomResult re = new CustomResult(data);
        re.setCode(0);
        re.setMsg("");
        re.setCount(1L);
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
