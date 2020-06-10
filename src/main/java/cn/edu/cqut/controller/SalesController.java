package cn.edu.cqut.controller;


import cn.edu.cqut.entity.Sales;
import cn.edu.cqut.service.ISalesService;
import cn.edu.cqut.util.CrmResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author HQYJ
 * @since 2020-06-03
 */
@RestController
@RequestMapping("/sales")
@CrossOrigin
@Api(tags = "客户管理")
public class SalesController {
    @Autowired
    private ISalesService salesService;

    @ApiOperation(value = "分页返回客户信息",
            notes = "分页查询客户信息，默认返回第一页，每页10行。还可以根据cusName模糊查询")
    @RequestMapping(value = "/sales"/*, method = RequestMethod.POST*/)
    public CrmResult<Sales> getAllSales(
            @ApiParam(value = "要查询的页码", required = true)
            @RequestParam(defaultValue = "1")
                    Integer page, //page请求的页码,默认为1
            @ApiParam(value = "每页的行数", required = true)
            @RequestParam(defaultValue = "10")
                    Integer limit,//limit每页的行数，默认为10
            Sales sales) {
        QueryWrapper<Sales> qw = new QueryWrapper<>();
        if (sales.getOrderNo() != null) {
            qw.like("orderNo", sales.getOrderNo()); //第一个参数是字段名
        }
        Page<Sales> pageSales = salesService.page(
                new Page<>(page, limit), qw);

        CrmResult<Sales> ret = new CrmResult<>();
        ret.setCode(0);
        ret.setMsg("");
        ret.setCount(pageSales.getTotal());//表里的记录总数
        ret.setData(pageSales.getRecords()); //这页的数据列表
        return ret;
    }

    @ApiIgnore
    @RequestMapping("/updateSales")
    public CrmResult<Sales> updateSales(Sales sales) {
        salesService.updateById(sales);  //根据主键更新表

        CrmResult<Sales> ret = new CrmResult<>();
        ret.setCode(0);
        ret.setMsg("更新客户成功");
        return ret;
    }

    @ApiIgnore
    @RequestMapping("/addSales")
    public CrmResult<Sales> addSales(Sales sales) {
        salesService.save(sales);

        CrmResult<Sales> ret = new CrmResult<>();
        ret.setCode(0);
        ret.setMsg("新增客户成功");
        return ret;
    }

    @ApiIgnore
    @RequestMapping("/delSales")
    public CrmResult<Sales> delSales(String[] ids) {
        salesService.removeByIds(Arrays.asList(ids));

        CrmResult<Sales> ret = new CrmResult<>();
        ret.setCode(0);
        ret.setMsg("删除客户成功");
        return ret;
    }
}
