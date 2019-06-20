package com.jk.bean;  /**
 * @title: UserBean
 * @projectName user-loginregistration
 * @description: TODO
 * @author Shady
 * @date 2019/6/1615:44
 */



/**
 *@Author: Shady
 *@Description: null
 *@Project_Name：user-loginregistration
 *@date：2019/6/16
 */


public class UserBean {
    private String phoneNumber;//账号
    private String password;//密码
    private String code;//验证码

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
}

