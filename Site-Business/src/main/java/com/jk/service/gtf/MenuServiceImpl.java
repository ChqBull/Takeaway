package com.jk.service.gtf;

import com.jk.bean.Menu;
import com.jk.bean.MenuType;
import com.jk.bean.Store;
import com.jk.mapper.gtf.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements  MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Map<String, Object> findMenuAll(Integer start, Integer pageSize, Menu menu) {
        int count=menuMapper.count(menu);
        List<Menu> list=menuMapper.findMenuAll(start,pageSize,menu);
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public List<MenuType> findMenuType() {
        return menuMapper.findMenuType();
    }

    @Override
    public void addMenuByStore(Menu menu) {
        menuMapper.addMenuByStore(menu);
    }

    @Override
    public void delMenu(Menu menu) {
        menuMapper.delMenu(menu);
    }

    @Override
    public List<Store> findStore() {
        return menuMapper.findStore();
    }
}
