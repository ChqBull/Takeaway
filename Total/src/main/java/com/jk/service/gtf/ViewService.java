package com.jk.service.gtf;

import com.jk.bean.ViewPager;

import java.util.Map;

public interface ViewService {

    Map<String, Object> findViewPageAll(Integer start, Integer pageSize);

    void addViewPage(ViewPager viewPager);

    void delViewPage(Integer id);
}
