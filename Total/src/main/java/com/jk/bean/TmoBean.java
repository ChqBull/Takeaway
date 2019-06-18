package com.jk.bean;

import lombok.Data;

@Data
public class TmoBean {
    private Integer id;
    private String foodName;//菜品名称
    private Integer menuCount;//菜的数量
    private Double price;//单价
    private Double totalprice;//总价
}
