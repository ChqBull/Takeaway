package com.jk.controller.zc;

import com.jk.bean.UserBean;
import com.jk.bean.dingdan;
import com.jk.service.zc.ZcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public HashMap<String,Object> finddingdan(HttpServletRequest request,dingdan hs){
        UserBean user = (UserBean)request.getSession().getAttribute("user");
        Integer id = user.getId();
        HashMap<String, Object> map = zcService.finddingdan(id, hs);
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
    public Integer workStatus(HttpServletRequest request){
        UserBean user = (UserBean)request.getSession().getAttribute("user");
        Integer id = user.getId();
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
    public String applyingUpWork(HttpServletRequest request){
        UserBean user = (UserBean)request.getSession().getAttribute("user");
        Integer id = user.getId();
        zcService.applyingUpWork(id);
        return null;
    }

    @RequestMapping("applyingDownWork")
    @ResponseBody
    public String applyingDownWork(HttpServletRequest request){
        UserBean user = (UserBean)request.getSession().getAttribute("user");
        Integer id = user.getId();
        zcService.applyingDownWork(id);
        return null;
    }
}
