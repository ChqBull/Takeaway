package com.jk.service.zc;

import com.jk.bean.dingdan;

import java.util.HashMap;

public interface ZcService {
    HashMap<String, Object> finddingdan(Integer pageSize, Integer start, dingdan hs);

    void updatedaodian(Integer id);

    void updatequcan(Integer id);

    void updatesongda(Integer id);
}
