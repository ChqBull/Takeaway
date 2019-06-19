package com.jk.controller.gtf;

import com.jk.bean.Menu;
import com.jk.bean.MenuType;
import com.jk.bean.Store;
import com.jk.service.gtf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("findMenuAll")
    @ResponseBody
    public Map<String,Object> findMenuAll(Integer start, Integer pageSize, Menu menu){
        return menuService.findMenuAll(start,pageSize,menu);
    }

    @RequestMapping("findMenuType")
    @ResponseBody
    public List<MenuType> findMenuType(){
        return menuService.findMenuType();
    }

    @RequestMapping("addMenuByStore")
    @ResponseBody
    public void addMenuByStore(Menu menu){
        try {
            menu.setShenhe(1);
            menuService.addMenuByStore(menu);
            redisTemplate.delete("findMenue"+menu.getStore_id());
            redisTemplate.delete("findMenue"+menu.getStore_id()+menu.getType_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("delMenu")
    @ResponseBody
    public void delMenu(Menu menu){
        menuService.delMenu(menu);
    }

    @RequestMapping("findStore")
    @ResponseBody
    public List<Store> findStore(){
        return menuService.findStore();
    }

}
