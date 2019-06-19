package com.jk.bean;


import java.io.Serializable;



public class PermissionBean implements Serializable {
    private static final long serialVersionUID = 3257833648244774323L;
    private Integer id;
    private String name;//权限名字
    private String url;//权限字段

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
