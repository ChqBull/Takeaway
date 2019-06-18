package com.jk.controller.yfz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /*用户登录展示页面*/
    @RequestMapping("toFindUserListAndOrderAndThoList")
    public String toFindUserListAndOrderAndThoList() {
        return "outList";
    }

    /*点击查看详情跳页面*/
    @RequestMapping("toFindDetailsList")
    public String toFindDetails(String orderNum) {
        return "detailsList";
    }
}
