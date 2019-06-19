package com.jk.service.zc;

import com.jk.bean.dingdan;
import com.jk.mapper.zc.ZcMappers;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ZcServiceImpl  implements  ZcService{
    @Resource
    ZcMappers zcMapper;
    @Override
    public HashMap<String, Object> finddingdan(dingdan hs) {
        List<dingdan> list=zcMapper.finddingdan(hs);
        long counr=zcMapper.finddingdancount();
        HashMap<String, Object>map=new HashMap<>();
        map.put("total",counr);
        map.put("rows",list);
        return map;
    }

    @Override
    public void updatedaodian(Integer id) {
        zcMapper.updatedaodian(id);
    }

    @Override
    public void updatequcan(Integer id) {
        zcMapper.updatequcan(id);
    }

    @Override
    public void updatesongda(Integer id) {
        zcMapper.updatesongda(id);
    }

    @Override
    public Integer workStatus(Integer id) {

        return zcMapper.workStatus(id);
    }

    @Override
    public void applyingUpWork(Integer id) {
        zcMapper.applyingUpWork(id);
    }
}
