package com.jk.rmi.syg;  /**
 * @title: UserClient
 * @projectName Takeaway
 * @description: TODO
 * @author Shady
 * @date 2019/6/1810:40
 */

import com.jk.bean.UserBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

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
    UserBean login(@RequestBody UserBean userBean);

}
