package com.jk.service.gtf;

import com.jk.bean.ViewPager;
import com.jk.mapper.gtf.ViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ViewServiceImpl implements ViewService{

    @Autowired
    private ViewMapper viewMapper;

    @Override
    public Map<String, Object> findViewPageAll(Integer start, Integer pageSize) {
        Map<String,Object> map=new HashMap<>();
        int count=viewMapper.count();
        List<ViewPager> list=viewMapper.findViewPageAll(start,pageSize);
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public void addViewPage(ViewPager viewPager) {
        viewMapper.addViewPage(viewPager);
    }

    @Override
    public void delViewPage(Integer id) {
        viewMapper.delViewPage(id);
    }
}
