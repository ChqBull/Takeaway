package com.jk.controller.zc;

import com.jk.bean.dingdan;
import com.jk.service.zc.ZcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class ZcController {

    @Resource
    ZcService zcService;

    @RequestMapping("getdingdan")

    public String  getdiagdan(){

        return "dingdan";
    }
    @RequestMapping("finddingdan")
    @ResponseBody
    public HashMap<String,Object> finddingdan(Integer pageSize, Integer start, dingdan hs){
        HashMap<String, Object> map = zcService.finddingdan(pageSize, start, hs);
        return map;
    }

    @RequestMapping("updatedaodian")
    @ResponseBody
    public  void updatedaodian(Integer id){
        zcService.updatedaodian(id);
    }
    @RequestMapping("updatequcan")
    @ResponseBody
    public  void updatequcan(Integer id){
        zcService.updatequcan(id);
    }
    @RequestMapping("updatesongda")
    @ResponseBody
    public  void updatesongda(Integer id){
        zcService.updatesongda(id);
    }

}
