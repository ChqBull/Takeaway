package com.jk.service.yfz;

import com.jk.bean.HorsemanBean;
import com.jk.bean.OrderBean;
import com.jk.mapper.yfz.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public HashMap<String, Object> findOrderList(Integer page, Integer rows, OrderBean orderBean) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("orderBean", orderBean);//存入实体,用于写条查
        int total = orderMapper.findOrderCount(orderBean);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<OrderBean> list = orderMapper.findOrderPage(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public HashMap<String,Object> findHorsemanList() {
        HashMap<String,Object> map = new HashMap<>();
        List<HorsemanBean> list = orderMapper.findHorsemanPage();
        for (HorsemanBean ho : list) {
            Integer id = ho.getId();
            Integer count = orderMapper.findHorsemanCount(id);
            ho.setOrderCount(count);
        }
        map.put("rows",list);
        return map;
    }

    @Override
    public void addOrderHoresman(String check, Integer horesmanId) {
        String[] split = check.split(",");
        orderMapper.updateZhiPai(check);
        orderMapper.addOrderHoresman(split,horesmanId);
    }

    @Override
    public HashMap<String,Object>  findHorsemanStatus() {
        List<HorsemanBean> list = orderMapper.findHorsemanStatus();
        HashMap<String,Object>map=new HashMap<>();
        map.put("rows",list);
        return map;
    }
}
