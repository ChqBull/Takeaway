package com.jk.mapper.gtf;

import com.jk.bean.Menu;
import com.jk.bean.MenuType;
import com.jk.bean.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    int count(@Param("m") Menu menu);

    List<Menu> findMenuAll(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("m") Menu menu);

    List<MenuType> findMenuType();

    void addMenuByStore(@Param("m") Menu menu);

    void delMenu(@Param("m") Menu menu);

    List<Store> findStore();
}
