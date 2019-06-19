package com.jk.service.serviceImpl;  /**
 * @title: UserServiceImpl
 * @projectName rider-loginregistration
 * @description: TODO
 * @author Shady
 * @date 2019/6/1615:40
 */


import com.jk.bean.UserBean;
import com.jk.mapper.UserMapper;
import com.jk.service.UserService;

import com.jk.util.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *@Author: Shady
 *@Description: null
 *@Project_Name：user-loginregistration
 *@date：2019/6/16
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;




    @Override
    public String phoneTest(String phoneNumber) {
        int num=(int)(Math.random()*9000)+1000;
        String msg="";
        String s = String.valueOf(num);
        redisTemplate.opsForValue().set("code",s);
        Map map = new HashMap();
        map.put("mobile",phoneNumber);
        map.put("tpl_id","156208");
        map.put("tpl_value","#code#="+s);
        map.put("key","9fad80e93bb180ffcbe9f3474ad87f7b");
        System.out.println(s);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String dt = simpleDateFormat.format(date);
        String s1 = UUID.randomUUID().toString();
        Long size = redisTemplate.opsForList().size(phoneNumber + dt);
        if (size>3){


            msg= "3";//验证码发送超过3次
        }
        if (valueOperations.get(phoneNumber)==null){
            msg= "4";//验证码超时一分钟
        }

        try {
            HttpClient.sendGet("http://v.juhe.cn/sms/send",map);
            valueOperations.set(phoneNumber,s1);
            redisTemplate.expire(phoneNumber,60, TimeUnit.SECONDS);
            redisTemplate.opsForList().leftPush(phoneNumber+dt,s1);
            redisTemplate.expire(phoneNumber+dt,86400,TimeUnit.SECONDS);
            msg= "2";//验证码发送成功
        }catch (Exception e){
            msg= "0";//验证码发送失败
        }
        return msg;
    }

    @Override
    public String register(UserBean userBean) {
        String msg="";
        String phoneNumber = userBean.getPhoneNumber();
        UserBean user = userMapper.findUserByPhone(phoneNumber);
        String code = userBean.getCode();
        String phoneCode = (String) redisTemplate.opsForValue().get("code");

        if (user!=null){
            msg = "该手机号已经被注册！" ;
        }
        if (!code.equals(phoneCode)){
            msg ="验证码输入不正确，请重新输入！";
        }
        if (user==null&&code.equals(phoneCode)){
            msg ="1";
            userMapper.saveOneUser(userBean);
        }
        return msg;
    }

    @Override
    public String login(UserBean userBean) {
        String msg="";
        String phoneNumber = userBean.getPhoneNumber();
        UserBean user = userMapper.findUserByPhone(phoneNumber);

        if (!phoneNumber.equals("")&&user==null){
                msg = "0";
        }
        if (user!=null){
            String password1 = userBean.getPassword();
            String password = user.getPassword();
            if (!password.equals(password1)){
                msg = "0";
            }else{
                 msg ="1";
            }

        }
        return msg;
    }
}
