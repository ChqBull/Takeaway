package com.jk.controller.yfz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("toFindOrderList")
    public String toFindOrderList(){
        return "orderList";
    }
}
