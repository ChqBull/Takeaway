package com.jk.controller.yfz;
import com.jk.bean.*;
import com.jk.service.yfz.StationAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@Controller
public class StationAgentController {
    @Autowired
    StationAgentService stationAgentService;

    /*站长表查询+分页+条查*/
    @RequestMapping("findStationAgentList")
    @ResponseBody
    public HashMap<String,Object> findStationAgentList(Integer page, Integer rows, StationAgentBean stationAgent){
        HashMap<String,Object> hash = stationAgentService.findStationAgentList(page,rows,stationAgent);
        return hash;
    }
    /*删除*/
    @RequestMapping("deleteStationAgent")
    @ResponseBody
    public Boolean deleteStationAgent(Integer id){
        try {
            stationAgentService.deleteStationAgent(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    /*新增查询城市*/
    @RequestMapping("findArea")
    @ResponseBody
    public List<AreaBean>findArea(){
        return stationAgentService.findArea();
    }

    /*新增站长+修改*/
    @RequestMapping("addActionAgent")
    @ResponseBody
    public Boolean addActionAgent(StationAgentBean stationAgent) {

        if(stationAgent.getId()==null) {
            /*新增*/
            return stationAgentService.addActionAgent(stationAgent);
        }else {
            /*修改*/
            return stationAgentService.updateActionAgentById(stationAgent);
        }
    }

    /*修改的回显*/
    @RequestMapping("findStationInfoById")
    @ResponseBody
    public StationAgentBean findStationInfoById(Integer id) {
        return stationAgentService.findStationInfoById(id);
    }



/*    *//*用户后登陆后页面加载展示*//*
    @RequestMapping("findUserListAndOrderAndThoList")
    @ResponseBody
    public HashMap<String,Object> findUserListAndOrderAndThoList(Integer page, Integer rows,OutBean outBean){
        HashMap<String,Object> hash = stationAgentService.findUserListAndOrderAndThoList(page,rows,outBean);
        return hash;
    }
   *//* 查看详情*//*
    @RequestMapping("findDetailsList")
    @ResponseBody
    public HashMap<String,Object> FindDetailsList(Integer page, Integer rows, TmoBean tmoBean){
        HashMap<String,Object> hashMap = stationAgentService.FindDetailsList(page,rows,tmoBean);
        return hashMap;
    }

   *//* 拒单*//*
    @RequestMapping("upDateJu")
    @ResponseBody
    public Boolean upDateJu(String id){
        try {
            stationAgentService.upDateJu(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   *//* 接单*//*
    @RequestMapping("updateJie")
    @ResponseBody
    public Boolean upDateJie(String id){
        try {
            stationAgentService.upDateJie(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
