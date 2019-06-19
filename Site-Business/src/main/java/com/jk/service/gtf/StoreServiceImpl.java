package com.jk.service.gtf;

import com.jk.bean.Store;
import com.jk.mapper.gtf.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Map<String, Object> findStoreAll(Integer start, Integer pageSize, Store store) {
        int count=storeMapper.count(store);
        List<Store> list=storeMapper.findStoreAll(start,pageSize,store);
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public Store findStoreById(Store store) {
        return storeMapper.findStoreById(store);
    }

    @Override
    public List<Store> findArea() {
        return storeMapper.findArea();
    }

    @Override
    public void addstore(Store store) {
        store.setShenhe(1);
        storeMapper.addstore(store);
    }

    @Override
    public void updstore(Store store) {
        store.setShenhe(1);
        storeMapper.updstore(store);
    }

    @Override
    public void delStore(Store store) {
        storeMapper.delStore(store);
    }
}
