package com.github.dairycode.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 在templates目录下的所有网页,只能通过controller来跳转!
// 这个需要模板引擎的依赖
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
