package com.jk.syg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

    @RequestMapping("/rider")
    public String rider(){
        return "/store/index";
    }

    @RequestMapping("/vip/index")
    public String vip(){
        return "/vip/index";
    }


}
