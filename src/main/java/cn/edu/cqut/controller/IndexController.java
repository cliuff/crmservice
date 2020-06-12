package cn.edu.cqut.controller;

import cn.edu.cqut.util.CustomResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@CrossOrigin
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index() {
        return "login/index.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CustomResult login() {
        CustomResult re = new CustomResult();
        re.setCode(0);
        re.setMsg("");
        re.setCount(0L);
        re.setData(null);
        return re;
    }
}
