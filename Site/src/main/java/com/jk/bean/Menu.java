package com.jk.bean;

import lombok.Data;

@Data
public class Menu {

    private Integer id;
    private String foodName;
    private String foodImg;
    private double price;
    private int type_id;
    private Integer store_id;
    private String menuType;
    private String storeName;
    private int shenhe;
}
