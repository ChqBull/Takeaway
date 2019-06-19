package com.jk.syg.service;


import com.jk.syg.bean.UserBean;

public interface UserService {
    UserBean findByName(String name);


    String registerData(String username, String password);
}
