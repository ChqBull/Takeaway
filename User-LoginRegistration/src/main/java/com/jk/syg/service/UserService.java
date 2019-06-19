package com.jk.syg.service;

import com.jk.syg.bean.UserBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Shady
 * @title: UserService
 * @projectName rider-loginregistration
 * @description: TODO
 * @date 2019/6/1615:37
 */
public interface UserService {

    String phoneTest( String phoneNumber);

    String register(UserBean userBean);

    String login(UserBean userBean);
}
