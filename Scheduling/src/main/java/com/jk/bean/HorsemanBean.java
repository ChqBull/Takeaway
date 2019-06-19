package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class HorsemanBean implements Serializable {
    private Integer id;
    private String horsemanName;//骑手姓名
    private String horsemanPhone;//骑手电话
    private Integer arriveStatus;//骑手状态
    private Integer orderCount;//骑手背单数
}
