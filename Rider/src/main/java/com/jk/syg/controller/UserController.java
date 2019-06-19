package com.jk.syg.controller;


import com.jk.syg.bean.UserBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    @RequestMapping("/rider")
    public String rider(){
        return "/rider/index";
    }

    @RequestMapping("/vip/index")
    public String vip(){
        return "/vip/index";
    }


}
