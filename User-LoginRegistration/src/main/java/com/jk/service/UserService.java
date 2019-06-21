package com.jk.service;

import com.jk.bean.UserBean;

import java.util.HashMap;

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

    UserBean login(UserBean userBean);
}
