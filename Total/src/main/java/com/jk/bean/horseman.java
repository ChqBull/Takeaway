package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class horseman implements Serializable {

    private  Integer id ;//主键ID
    private  String   horsemanName ;//骑手姓名
    private  String horsemanPhone;//骑手电话（登陆的账号）
    private  String password;//登陆的密码
    private  String idCard;//份证号身
    private  Integer arriveStatus;//是否到店 0没到店，1已经到店
    private  Integer getFoodStatus;//是否取餐 0没取，1取了
    private  Integer deliverStatus;//是否送达 0运输中，1用户已经取货
    private  Integer area_id;//骑手属于哪个区
    private  Integer shenhe;//审核通过状态1没通过2通过
}
