package com.jk.service;


import com.jk.bean.UserBean;

public interface UserService {
    UserBean findByName(String name);


    String registerData(String username, String password);
}
