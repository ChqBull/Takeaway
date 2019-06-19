package com.jk.service.syg;

import com.jk.bean.UserBean;
import com.jk.mapper.syg.UserMapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserMapper userMapper;

    @Override
    public UserBean findByName(String name) {
        // 查询用户是否存在
       List<UserBean> bean  = userMapper.findByName(name);
        UserBean user=null;
        if (bean != null) {
            // 查询用户信息、角色、权限
            for (UserBean userBean : bean) {
                if (userBean.getName().equals(name)){
                    user= userBean;
                }
            }
            user = userMapper.findById(user.getName());


        }
        return user;
    }


    @Override
    public String registerData(String username, String password) {
        String msg="";
        // 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes(username);

        String newPs = new SimpleHash("MD5", password, salt, 1).toHex();
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", username);
        dataMap.put("password", newPs);

        // 看数据库中是否存在该账户
       List<UserBean> userInfo = userMapper.queryInfoByUsername(username);
        if(userInfo.size()==0) {
            userMapper.insertData(dataMap);
            msg= "1";
        }else{
            msg= "0";
        }
            return msg;


    }
}

