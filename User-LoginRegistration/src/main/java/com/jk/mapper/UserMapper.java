package com.jk.mapper;

import com.jk.bean.UserBean;
import org.springframework.stereotype.Repository;

/**
 * @author Shady
 * @title: UserMapper
 * @projectName rider-loginregistration
 * @description: TODO
 * @date 2019/6/1615:43
 */
@Repository
public interface UserMapper {

    UserBean findUserByPhone(String phoneNumber);

    void saveOneUser(UserBean userBean);


}
