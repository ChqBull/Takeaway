package com.jk.service.zc;

import com.jk.bean.MenuBean;
import com.jk.bean.MenuTree;
import com.jk.bean.horseman;
import com.jk.bean.store;
import com.jk.mapper.zc.ZcMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ZcServiceImpl  implements  ZcService{

    @Resource
    ZcMapper zcMapper;

    @Override
    public HashMap<String, Object> findqishou(Integer pageSize, Integer start, horseman hs) {
        List<horseman>list=zcMapper.findlist(pageSize,start,hs);
        long counr=zcMapper.findcount();
        HashMap<String, Object>map=new HashMap<>();
        map.put("total",counr);
        map.put("rows",list);
        return map;
    }

    @Override
    public void updateshenhe(Integer id) {
        zcMapper.updateshenhe(id);
    }

    @Override
    public HashMap<String, Object> finddianpu(Integer pageSize, Integer start, store hs) {
        List<store>list=zcMapper.findlisttwo(pageSize,start,hs);
        long counr=zcMapper.findlist2();
        HashMap<String, Object>map=new HashMap<>();
        map.put("total",counr);
        map.put("rows",list);
        return map;
    }

    @Override
    public void updatedianmian(Integer id) {
        zcMapper.updatedianmian(id);
    }

    @Override
    public HashMap<String, Object> findcaidan(MenuBean hs) {
        List<MenuBean>list=zcMapper.findcaidan(hs);
        HashMap<String, Object>map=new HashMap<>();
        map.put("rows",list);
        return map;
    }

    @Override
    public void updatecaidan(Integer id) {
        zcMapper.updatecaidan(id);
    }

    @Override
    public List<MenuTree> findtree() {
        return zcMapper.findtree();
    }

    @Override
    public MenuBean chakanxiangqing(Integer id) {
        return zcMapper.chakanxiangqing(id);
    }
}
