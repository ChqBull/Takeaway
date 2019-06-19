package com.jk.controller.syg;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
