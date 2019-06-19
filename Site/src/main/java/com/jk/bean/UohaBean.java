package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UohaBean {
    private Integer id;
    private String orderNum;
    private String realName;//用户姓名
    private String storeName;//商家店名
    private Double orderMoney;//订单总价
    @DateTimeFormat(pattern = "yyyy-MM-dd") //入参
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") //出参
    private Date orderStartTime;//下单时间
    //用于时间条查
    @DateTimeFormat(pattern = "yyyy-MM-dd") //入参
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") //出参
    private Date startTime;//开始时间

    @DateTimeFormat(pattern = "yyyy-MM-dd") //入参
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd") //出参
    private Date endTime ;//结束时间

    private String horsemanName;//骑手姓名
    private String address;//收货地址
}
