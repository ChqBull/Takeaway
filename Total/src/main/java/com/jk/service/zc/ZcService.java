package com.jk.service.zc;

import com.jk.bean.MenuBean;
import com.jk.bean.horseman;
import com.jk.bean.store;

import java.util.HashMap;

public interface ZcService {
    HashMap<String, Object> findqishou(Integer pageSize, Integer start, horseman hs);

    void updateshenhe(Integer id);

    HashMap<String, Object> finddianpu(Integer pageSize, Integer start, store hs);

    void updatedianmian(Integer id);

    HashMap<String, Object> findcaidan(Integer pageSize, Integer start, MenuBean hs);

    void updatecaidan(Integer id);
}
