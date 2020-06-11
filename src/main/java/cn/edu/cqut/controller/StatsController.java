package cn.edu.cqut.controller;

import cn.edu.cqut.entity.Customer;
import cn.edu.cqut.service.ICusflewService;
import cn.edu.cqut.service.ICustomerService;
import cn.edu.cqut.service.ServiceService;
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
    public static final int CUSTOMER_COL_RANK = 0;
    public static final int CUSTOMER_COL_CREDIT = 1;
    public static final int CUSTOMER_COL_SATISFACTION = 2;
    public static final int CUSTOMER_COL_REGION = 3;

    private final ICustomerService customerService;
    private final ICusflewService lostCustomerService;
    private final ServiceService serviceService;

    @Autowired
    public StatsController(
            ICustomerService customerService,
            ICusflewService lostCustomerService,
            ServiceService serviceService) {
        this.customerService = customerService;
        this.lostCustomerService = lostCustomerService;
        this.serviceService = serviceService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public CrmResult<Customer> getCustomers(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            Customer customer,
            String date1,
            String date2) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        String customerName = customer.getCusName();
        if (customerName != null) {
            queryWrapper.like("cusName", customerName);
        }
        if (date1 != null && date2 != null) {
            queryWrapper.between("orderTime",
                    "date('" + date1 + "-01-01')",
                    "date('" + date2 + "-01-01')");
        }
        Page<Customer> customerPage = new Page<>(page, limit);
        customerService.getTotalTransactionAmount(customerPage, queryWrapper);
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
            case CUSTOMER_COL_REGION:
                column = "cusRegion";
                columnName = "所在地区";
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

    @RequestMapping(value = "/lost-customers", method = RequestMethod.POST)
    public CrmResult<Customer> getLostCustomerRecords(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            Customer customer) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        String customerName = customer.getCusName();
        if (customerName != null) {
            queryWrapper.like("cusName", customerName);
        }
        Page<Customer> customerPage = new Page<>(page, limit);
        lostCustomerService.getLost(customerPage, queryWrapper);
        CrmResult<Customer> re = new CrmResult<>();
        re.setCode(0);
        re.setMsg("");
        re.setCount(customerPage.getTotal());
        re.setData(customerPage.getRecords());
        return re;
    }

    @RequestMapping(value = "/service-composition", method = RequestMethod.POST)
    public CustomResult getServiceComposition() {
        String columnName = "服务类型";
        String column = "service_type";
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy(column);
        queryWrapper.select(column + " name", "count(*) count");
        String title = "服务构成";

        List<SimpleCategory> categoryList = serviceService.getServiceComposition(queryWrapper);
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
}
