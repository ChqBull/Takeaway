package com.jk.controller.zc;


import com.jk.bean.MenuTree;
import com.jk.service.zc.TreeService;
import com.jk.util.TreeNoteUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
public class TreeController {


    @Resource
    TreeService treeService;

    @RequestMapping("findtree")
    @ResponseBody
    public  List<MenuTree> findtree(){
        HashMap<String,Object>map=new HashMap<>();
        List<MenuTree>list=treeService.findtree();
        list=TreeNoteUtil.getFatherNode(list);
        map.put("rows",list);
        return list;
    }
    @RequestMapping("gettree")
    public String gettree(){

        return "tree";
    }
    @RequestMapping("findtree2")
    @ResponseBody
    public  List<MenuTree> findtree2(){
        HashMap<String,Object>map=new HashMap<>();
        List<MenuTree>list=treeService.findtree2();
        list=TreeNoteUtil.getFatherNode(list);
        map.put("rows",list);
        return list;
    }
    @RequestMapping("gettree2")
    public String gettree2(){

        return "tree2";
    }
}
