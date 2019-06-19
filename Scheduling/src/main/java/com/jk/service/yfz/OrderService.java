package com.jk.service.yfz;

import com.jk.bean.HorsemanBean;
import com.jk.bean.OrderBean;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    HashMap<String, Object> findOrderList(Integer page, Integer rows, OrderBean orderBean);

    HashMap<String,Object> findHorsemanList();

    void addOrderHoresman(String check, Integer horesmanId);

    HashMap<String,Object>  findHorsemanStatus();

}
