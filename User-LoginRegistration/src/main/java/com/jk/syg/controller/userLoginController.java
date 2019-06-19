package com.jk.syg.controller;


import com.jk.MyLog;
import com.jk.syg.bean.UserBean;
import com.jk.syg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@Author: Shady
 *@Description: none
 *@Project_Name：user-loginregistration
 *@date：2019/6/14
 */

@Controller
public class userLoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/userLogin")
    public String userLogin(){
        return "userLogin";
    }

    @RequestMapping("/userRegister")
    public String userRegister(){
        return "userRegister";
    }

    @MyLog(value = "用户登录记录")
    @RequestMapping("/homepage")
    public String homepage(){
        return "homepage";
    }

    /*手机验证码*/
    @RequestMapping("phoneTest")
    @ResponseBody
    public String  phoneTest(@RequestParam("phoneNumber") String phoneNumber) {
        return userService.phoneTest(phoneNumber);
    }

    /*注册*/
    @RequestMapping("register")
    @ResponseBody
    public String register(@RequestBody UserBean userBean) {
        String msg = userService.register(userBean);
        return msg;
    }

    /*登录*/
    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestBody UserBean userBean) {
        String msg = userService.login(userBean);
        return msg;
    }

}
