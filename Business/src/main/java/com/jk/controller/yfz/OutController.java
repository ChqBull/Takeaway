package com.jk.controller.yfz;

import com.jk.bean.OutBean;

import com.jk.bean.TmoBean;
import com.jk.service.yfz.OutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class OutController {
    @Autowired
    OutService outService;

    //*用户后登陆后页面加载展示*//
    @RequestMapping("findUserListAndOrderAndThoList")
    @ResponseBody
    public HashMap<String,Object> findUserListAndOrderAndThoList(Integer page, Integer rows,OutBean outBean){
        HashMap<String,Object> hash = outService.findUserListAndOrderAndThoList(page,rows,outBean);
        return hash;
    }
    //*查看详情*//
    @RequestMapping("findDetailsList")
    @ResponseBody
    public HashMap<String,Object> FindDetailsList(Integer page, Integer rows, TmoBean tmoBean){
        HashMap<String,Object> hashMap = outService.FindDetailsList(page,rows,tmoBean);
        return hashMap;
    }

    //*拒单*//
    @RequestMapping("upDateJu")
    @ResponseBody
    public Boolean upDateJu(String id){
        try {
            outService.upDateJu(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //*接单*//
    @RequestMapping("updateJie")
    @ResponseBody
    public Boolean upDateJie(String id){
        try {
            outService.upDateJie(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
