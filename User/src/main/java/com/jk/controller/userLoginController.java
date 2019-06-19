package com.jk.controller;

import com.jk.MyLog;
import com.jk.bean.UserBean;
import com.jk.rmi.syg.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *@Author: Shady
 *@Description: none
 *@Project_Name：user-loginregistration
 *@date：2019/6/14
 */

@Controller
public class userLoginController {

    @Autowired
    UserClient userClient;

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
    public String  phoneTest(String phoneNumber) {
        return userClient.phoneTest(phoneNumber);
    }

    /*注册*/
    @RequestMapping("register")
    @ResponseBody
    public String register(UserBean userBean) {
        String msg = userClient.register(userBean);
        return msg;
    }

    /*登录*/
    @RequestMapping("login")
    @ResponseBody
    public String login(UserBean userBean,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String msg = userClient.login(userBean);
        if (msg.equals("1")){
            session.setAttribute("user",userBean);
            System.out.println("缓存成功！");
        }
        return msg;
    }
}
