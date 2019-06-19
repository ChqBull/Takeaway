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
    public HashMap<String,Object> finddingdan(dingdan hs){
        HashMap<String, Object> map = zcService.finddingdan( hs);
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

    @RequestMapping("workStatus")
    @ResponseBody
    public Integer workStatus(Integer id){
        Integer i = zcService.workStatus(id);
        if(i==1 || i == 2){
            i = 0;
        }else {
            i = 1;
        }
        return i;
    }
    @RequestMapping("applyingUpWork")
    @ResponseBody
    public String applyingUpWork(Integer id){
        zcService.applyingUpWork(id);
        return null;
    }

    @RequestMapping("applyingDownWork")
    @ResponseBody
    public String applyingDownWork(){

        return null;
    }
}
