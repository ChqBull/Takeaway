package com.jk.service.gtf;

import com.jk.bean.Store;

import java.util.List;
import java.util.Map;

public interface StoreService {
    Map<String, Object> findStoreAll(Integer start, Integer pageSize, Store store);

    Store findStoreById(Store store);

    List<Store> findArea();

    void addstore(Store store);

    void updstore(Store store);

    void delStore(Store store);
}
