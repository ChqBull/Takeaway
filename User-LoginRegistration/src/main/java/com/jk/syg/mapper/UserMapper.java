package com.jk.syg.mapper;

import com.jk.syg.bean.UserBean;

/**
 * @author Shady
 * @title: UserMapper
 * @projectName rider-loginregistration
 * @description: TODO
 * @date 2019/6/1615:43
 */
public interface UserMapper {

    UserBean findUserByPhone(String phoneNumber);

    void saveOneUser(UserBean userBean);


}
