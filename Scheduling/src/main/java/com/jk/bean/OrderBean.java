package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class OrderBean {
    private Integer id;//主键ID
    private String orderNum;//订单号
    private Integer user_id;//用户ID
    private Integer store_id;//商家ID
    private Double orderMoney;//订单总价
    private String msg;//订单备注
    private Date orderStartTime;//下单时间
    private Date orderEndTime;//订单完成时间（所有状态都对的时候，修改当前时间）
    private Integer orderStatus;//0没接单，1接单
    private Integer horseStatus;//
}
