package com.jk.mapper.zc;

import com.jk.bean.MenuBean;
import com.jk.bean.MenuTree;
import com.jk.bean.horseman;
import com.jk.bean.store;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZcMapper{

    List<horseman> findlist(@Param("pageSize") Integer pageSize, @Param("start") Integer start,horseman hs);

    @Select("select count(*) from  horseman")
    long findcount();

    @Update("update horseman set shenhe=2 where id=#{id}")
    void updateshenhe(@Param("id") Integer id);

    List<store> findlisttwo(@Param("pageSize")Integer pageSize, @Param("start") Integer start, store hs);

    @Select("select count(*) from  store")
    long findlist2();

    @Update("update store set shenhe=2 where id=#{id}")
    void updatedianmian(@Param("id") Integer id);

    List<MenuBean> findcaidan(MenuBean hs);

    @Select("select count(*) from  menu")
    long findcaidancount();

    @Update("update menu set shenhe=2 where id=#{id}")
    void updatecaidan(Integer id);
    @Select("select * from  tree2")
    List<MenuTree> findtree();

    MenuBean chakanxiangqing(@Param("id") Integer id);
}
