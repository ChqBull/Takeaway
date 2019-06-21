package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class menuBean implements Serializable {
          private String id;
          private String foodName;
          private String foodImg;
          private String price;
          private String type_id;
          private String store_id;
          private String shenhe;
          //获取菜单的数量
          private Integer number;
         private String menuType;

}
