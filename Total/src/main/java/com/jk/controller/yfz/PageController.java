package com.jk.controller.yfz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /*跳到站长查询页面*/
    @RequestMapping("findStationAgent")
    public String findStationAgent(){
        return "stationAgentlist";
    }
    /*跳到新增页面*/
    @RequestMapping("pageAddActionAgent")
    public String pageAddActionAgent(){
        return "addActionAgent";
    }

    /*跳到修改页面*/
    @RequestMapping("toEditPage")
    public String toEditPage(Integer id) {
        return "editActionAgent";
    }

   /* *//*用户登录展示页面*//*
    @RequestMapping("toFindUserListAndOrderAndThoList")
    public String toFindUserListAndOrderAndThoList() {
        return "outList";
    }

    *//*点击查看详情跳页面*//*
    @RequestMapping("toFindDetailsList")
    public String toFindDetails(String orderNum) {
        return "detailsList";
    }
*/

}
