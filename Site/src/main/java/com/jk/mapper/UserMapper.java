package com.jk.mapper;

import com.jk.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    // 查询用户信息
    @Select("select * from `user` where name= #{name}")
    List<UserBean> findByName(@Param("name") String name);

    // 查询用户信息、角色、权限
    UserBean findById(String name);

    void insertData(Map<String, String> dataMap);

    List<UserBean> queryInfoByUsername(String username);
}
