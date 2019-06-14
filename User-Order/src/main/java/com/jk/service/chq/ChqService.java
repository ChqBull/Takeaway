package com.jk.service.chq;

import com.jk.bean.StoreBean;

import java.util.HashMap;

public interface ChqService {
    HashMap<String, Object> findBusiness(Integer page, Integer limit, StoreBean storeBean);
}
