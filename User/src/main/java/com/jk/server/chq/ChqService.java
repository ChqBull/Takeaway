package com.jk.server.chq;

import com.jk.bean.Area;
import com.jk.bean.address;
import com.jk.bean.menuBean;
import com.jk.bean.menuType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ChqService {


    List<Area> findArea();

    List<menuType> findmenuType();

    List<menuBean> findMenue(String id);

    List<menuBean> findMenuetypeId(String id, String typeId);

    void ali(HttpServletResponse response, HttpServletRequest request);

    void add(String area, Integer phoneNumber);

    List<address> queryUserArea(Integer phoneNumber);

    void addOrder(long dateTime, Integer id2, String storeid, String price, String msg, String area, String ids, String numbers);

    menuBean chakanxiangqing(Integer id, Integer storeid);
}
