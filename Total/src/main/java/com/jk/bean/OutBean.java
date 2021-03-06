package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class OutBean {
    private String orderNum;//订单号
    private String horsemanName;//骑手姓名
    private String orderMoney;//订单总价
    private String horsemanPhone;//骑手电话
    private Double orderStartTime;//下单时间
    private Date orderEndTime;//订单完成时间
    private String realName;//用户姓名
    private String userPhone;//用户手机号
    private String msg;//备注
    private Integer orderStatus;//状态 0拒单，1接单，2超时
}
