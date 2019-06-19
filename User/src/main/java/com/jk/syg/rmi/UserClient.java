package com.jk.syg.rmi;  /**
 * @title: UserClient
 * @projectName Takeaway
 * @description: TODO
 * @author Shady
 * @date 2019/6/1810:40
 */

import com.jk.syg.bean.UserBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 *@Author: Shady
 *@Description: null
 *@Project_Name：Takeaway
 *@date：2019/6/18
 */

@FeignClient(value="userloginregistration")
public interface UserClient {

    @RequestMapping("phoneTest")
    String phoneTest(@RequestParam("phoneNumber") String phoneNumber);

    @RequestMapping("register")
    String register(@RequestBody UserBean userBean);

    @RequestMapping("login")
    String login(@RequestBody UserBean userBean);

}
