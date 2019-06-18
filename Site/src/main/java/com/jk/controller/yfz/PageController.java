package com.jk.controller.yfz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /*到财务查询页面*/
    @RequestMapping("toFindUohaList")
    public String toFindUohaList(){
        return "uohaList";
    }
}
