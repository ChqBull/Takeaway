package com.jk.controller.chq;

import com.jk.bean.StoreBean;
import com.jk.rmi.chq.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class ChqController {

    @Autowired
    OrderClient orderClient;

    @RequestMapping("findBusiness")
    @ResponseBody
    public HashMap<String , Object> findBusiness(Integer start,Integer pageSize , StoreBean storeBean){
        HashMap<String , Object> map = orderClient.findBusiness(start,pageSize,storeBean);
        return map;
    }

    @RequestMapping("goBusinessPage")
    public String goBusinessPage(){

        return "goBusinessPage";
    }
}
