package com.jk.service.gtf;

import com.jk.bean.Menu;
import com.jk.bean.MenuType;
import com.jk.bean.Store;

import java.util.List;
import java.util.Map;

public interface MenuService {
    Map<String, Object> findMenuAll(Integer start, Integer pageSize, Menu menu);

    List<MenuType> findMenuType();

    void addMenuByStore(Menu menu);

    void delMenu(Menu menu);

    List<Store> findStore();

}
