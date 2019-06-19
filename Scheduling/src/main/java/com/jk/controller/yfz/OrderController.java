package com.jk.controller.yfz;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.OrderBean;
import com.jk.service.yfz.OrderService;
import com.jk.utlis.ConstantConf;
import com.jk.utlis.HttpClientUtil;
import com.jk.utlis.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

  /*  @Resource
    private JedisPool jedisPool;*/

    /*查询订单状态为1 没接单0  写死的*/
    @RequestMapping("findOrderList")
    @ResponseBody
    public HashMap<String,Object> findOrderList(Integer page, Integer rows, OrderBean orderBean){
        HashMap<String,Object> hash = orderService.findOrderList(page,rows,orderBean);
        return hash;
    }
    /*查询骑手arriveStatus=1写死*/
    @RequestMapping("findHorsemanList")
    @ResponseBody
    public HashMap<String,Object> findHorsemanList(){
        return orderService.findHorsemanList();
    }

    @RequestMapping("addOrderHoresman")
    @ResponseBody
    public String addOrderHoresman(Integer horesmanId,String check){
        orderService.addOrderHoresman(check,horesmanId);
        return null;
    }

    /*查询骑手arriveStatus=0写死*/
    @RequestMapping("findHorsemanStatus")
    @ResponseBody
    public HashMap<String,Object> findHorsemanStatus(){
        HashMap<String,Object> list = orderService.findHorsemanStatus();
        return list;
    }
    /*短信提醒骑手上线*/
    @RequestMapping("duanXin")
    @ResponseBody
    public HashMap<String, Object> duanXin(String horsemanPhone) {
       /* Jedis redis = jedisPool.getResource();*/
        HashMap<String, Object> hash = new HashMap<>();
       /* Integer randomNumber = (int) (Math.random() * 899999 + 100000);*/
        String randomNumber = ("骑手大神上班啦!上班啦!!!");
        System.out.println(randomNumber);

/*          HashMap<String, Object> params = new HashMap<>();
         *//*发送短信*//*
        params.put("accountSid", ConstantConf.ACCOUNTSID);
        params.put("to",horsemanPhone);
        String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        params.put("timestamp",timestamp);
        String sig= Md5Util.getMd532(ConstantConf.ACCOUNTSID+ConstantConf.AUTH_TOKEN+timestamp);
        params.put("sig",sig);
        params.put("templateid",ConstantConf.TEMPLATEID);
        params.put("param",randomNumber);
        String string = HttpClientUtil.post(ConstantConf.SMS_URL,params);

        System.out.println(string);

        JSONObject parseObject = JSON.parseObject(string);
        String string2 = parseObject.getString("respCode");
        if(ConstantConf.SMS_SUCCESS.equals(string2)) {*/
        String s = randomNumber.toString();
       /* redis.set(horsemanPhone, s);
        redis.expire(horsemanPhone, 60);*/
      /*  redis.lpush(horsemanPhone + format, s);
        redis.expire(horsemanPhone + format, 86400);*/
        hash.put("yzm", randomNumber);
        hash.put("code", 0);
        hash.put("msg", "提醒成功,稍后骑手小哥哥就会上班哦");
        return hash;
      /* }else {
            hash.put("code", 1);
            hash.put("msg", "发送失败");
            return hash;
        }*/
    }
}
