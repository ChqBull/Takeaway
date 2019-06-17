package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class store implements Serializable {


    private  Integer id;
    private  String  storeName;//商家店名
    private  String  storeAddress;//商家地址
    private  String  storeLinkman;//商家联系人姓名
    private  String  storePhone;//商家联系电话（登陆的账号）
    private  String  password;//商家登陆密码
    private  String  storeIdCard;//商家联系人身份证
    private  String  bussinessLicense;//营业执照图片路径，OSS
    private  String  storeImg;//店铺图片，OSS
    private  String  activity;//满减
    private  String  area_id;//店铺属于哪个地区
    private  Integer shenhe;//审核通过状态1没通过2通过

}
