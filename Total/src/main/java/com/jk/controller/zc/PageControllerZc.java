package com.jk.controller.zc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControllerZc {

    @RequestMapping("getqishou")
    public  String getqishou(){
        return "qishou";
    }

    @RequestMapping("getdianmian")
    public  String getdianmian(){
        return "dianpu";
    }

    @RequestMapping("getcaidan")
    public  String getcaidan(){
        return "caidan";
    }

    @RequestMapping("gettree")
    public String gettree2(){

        return "tree";
    }

}
