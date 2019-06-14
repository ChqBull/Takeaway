package com.jk.service.chq;

import com.jk.bean.StoreBean;
import com.jk.mapper.chq.ChqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ChqServiceImpl implements ChqService {

    @Autowired
    ChqMapper chqMapper;

    @Override
    public HashMap<String, Object> findBusiness(Integer page, Integer limit, StoreBean storeBean) {
        HashMap<String ,Object> map = new HashMap<>();
        Long count = chqMapper.findBusinessCount();
        List<StoreBean> li = chqMapper.findBusiness(page,limit,storeBean);
        return null;
    }
}
