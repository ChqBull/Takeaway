package com.jk.bean;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class UserBean implements Serializable {

    private static final long serialVersionUID = -6380679827539254303L;
    private Integer id;
    private String name;//用户名
    private String password;//密码
    private Set<RoleBean> roles = new HashSet<>();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleBean> roles) {
        this.roles = roles;
    }
}
