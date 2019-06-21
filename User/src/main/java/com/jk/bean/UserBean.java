package com.jk.bean;  /**
 * @title: UserBean
 * @projectName rider-loginregistration
 * @description: TODO
 * @author Shady
 * @date 2019/6/1615:44
 */


import java.io.Serializable;

/**
 *@Author: Shady
 *@Description: null
 *@Project_Name：user-loginregistration
 *@date：2019/6/16
 */


public class UserBean implements Serializable {
    private String phoneNumber;
    private String password;
    private String realName;
    private Integer id;
    private String code;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

