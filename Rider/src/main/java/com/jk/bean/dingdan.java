package com.jk.bean;

import lombok.Data;

@Data
public class dingdan {
    private  Integer id;//订单id
    private  String orderNum;//订单号
    private  String storeName;//商家店名
    private  String storePhone;//商家联系电话（登陆的账号）
    private  String realName;//用户姓名
    private  String userPhone;//用户手机号（登陆账号）
    private  String msg;//订单备注
    private  String address;//收货地址
    private  Integer orderStatus;//0没接单，1接单，2超时
    private  Integer horseStatus;//1待到店  2待取餐  3待送达  4已送达






}
