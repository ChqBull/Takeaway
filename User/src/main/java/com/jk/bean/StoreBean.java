package com.jk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

@AllArgsConstructor

//使用后创建一个无参构造函数
@NoArgsConstructor
@Data
public class StoreBean implements Serializable {
    @Field(value = "id")
    private String id;
    @Field(value = "storeName")
    private String storeName;
    @Field(value = "storeAddress")
    private String storeAddress;
    @Field(value = "storeLinkman")
    private String storeLinkman;
    @Field(value = "storePhone")
    private String storePhone;
    @Field(value = "password")
    private String password;
    @Field(value = "storeIdCard")
    private String storeIdCard;
    @Field(value = "bussinessLicense")
    private String bussinessLicense;
    @Field(value = "storeImg")
    private String  storeImg;
    @Field(value = "activity")
    private String activity;
    @Field(value = "area_id")
    private String area_id;

}
