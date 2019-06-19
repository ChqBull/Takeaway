package com.jk.syg.service;


import com.jk.syg.bean.UserBean;

import java.util.List;

public interface UserService {
    UserBean findByName(String name);


    String registerData(String username, String password);
}
