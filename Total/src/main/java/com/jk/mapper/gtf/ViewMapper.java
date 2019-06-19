package com.jk.mapper.gtf;

import com.jk.bean.ViewPager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewMapper {

    int count();

    List<ViewPager> findViewPageAll(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    void addViewPage(@Param("v") ViewPager viewPager);

    void delViewPage(@Param("id") Integer id);
}
