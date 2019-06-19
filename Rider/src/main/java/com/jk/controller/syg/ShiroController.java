package com.jk.controller.syg;

import com.jk.bean.UserBean;
import com.jk.service.syg.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ShiroController {
    @Autowired
    UserService userService;
    //主页面

    //登陆页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }



    //点击登录后获取的前台信息
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request){
        //获取到请求的头名字  freemarker模板时使用

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String msg="";
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 3.执行登录方法
        try{
            subject.login(token);
            boolean isAuthenticated = subject.isAuthenticated();
            System.out.println("是否认证通过: " + isAuthenticated);
            HttpSession session = request.getSession();
            session.setAttribute("username",userName);

            UserBean user = userService.findByName(userName);
            Integer id = user.getId();
            if (id==1){
                return "1";
            }
            if (id==2){
                return "2";
            }
            if (id==3){
                return "3";
            }
        } catch (UnknownAccountException e){
            e.printStackTrace();
            boolean isAuthenticated = subject.isAuthenticated();
            System.out.println("是否认证通过: " + isAuthenticated);
            msg = "用户名不存在！";

        } catch (IncorrectCredentialsException e){
            boolean isAuthenticated = subject.isAuthenticated();
            System.out.println("是否认证通过: " + isAuthenticated);
            msg = "密码错误！";
        }
        return msg;
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "redirect:/main";
    }

    //未授权提示页面
    @RequestMapping("/error/unAuth")
    public String unAuth(){
        return "/error/unAuth";
    }


    //用户注册

        @RequestMapping("/doRegister")
        @ResponseBody
        public String doRegister(UserBean user) {
            String username = user.getName();
            String password = user.getPassword();
            String msg = userService.registerData(username, password);
            if (msg.equals("0")){
                return msg;
            }
            return "1";
        }
    }


