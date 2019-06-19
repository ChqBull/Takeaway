package com.jk.controller.gtf;

import com.jk.bean.Menu;
import com.jk.bean.Store;
import com.jk.service.gtf.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("storepage")
    public String storepage(){
       return "storepage";
    }

    @RequestMapping("toAddstore")
    public String toAddstore(Store store, Model model){
        if (store.getId()!=null){
            Store s=storeService.findStoreById(store);
            model.addAttribute("s",s);
        }
        return "addstore";
    }

    @RequestMapping("menupage")
    public String menupage(Menu menu,Model model){
        if (menu.getId()!=null){
            model.addAttribute("s",menu);
        }
        return "menupage";
    }

    @RequestMapping("toAddMenu")
    public String toAddMenu(){
        return "addMenu";
    }

}
