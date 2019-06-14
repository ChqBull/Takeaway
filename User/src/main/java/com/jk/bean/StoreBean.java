package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class StoreBean implements Serializable {

    private Integer id;
    private String storeName;
    private String storeAddress;
    private String storeLinkman;
    private String storePhone;
    private String password;
    private String storeIdCard;
    private String bussinessLicense;
    private String  storeImg;
    private String activity;
    private Integer area_id;

}
