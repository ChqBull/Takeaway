package com.jk.syg.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class RoleBean implements Serializable {

    private static final long serialVersionUID = -3802837197093382467L;
    private Integer id;
    private String name;//角色名字
    private Set<PermissionBean> permissions = new HashSet<>();

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

    public Set<PermissionBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionBean> permissions) {
        this.permissions = permissions;
    }
}
