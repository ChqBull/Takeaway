package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuBean implements Serializable {

    private Integer id;
    private String foodName;//菜品名称
    private String foodImg;//菜品图片
    private Double price;//单价
    private Integer type_id;//菜属于什么类型
    private Integer store_id;//属于哪家店铺
    private  Integer shenhe;//审核通过状态1没通过2通过

    private String activity;
    private String storeName;
    private String menuType;
    //获取菜单的数量
    private Integer number;

}
