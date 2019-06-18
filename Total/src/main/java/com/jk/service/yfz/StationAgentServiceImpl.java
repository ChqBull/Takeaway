package com.jk.service.yfz;

import com.jk.bean.AreaBean;
import com.jk.bean.OutBean;
import com.jk.bean.StationAgentBean;
import com.jk.bean.TmoBean;
import com.jk.mapper.yfz.StationAgentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StationAgentServiceImpl implements StationAgentService{

    @Autowired
    StationAgentMapper stationAgentMapper;

    @Override
    public HashMap<String, Object> findStationAgentList(Integer page, Integer rows, StationAgentBean stationAgent) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("stationAgent", stationAgent);//存入实体,用于写条查
        int total = stationAgentMapper.findStationAgentCount(stationAgent);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<StationAgentBean> list = stationAgentMapper.findStationAgentPage(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public void deleteStationAgent(Integer id) {
        stationAgentMapper.deleteStationAgent(id);
    }

    @Override
    public List<AreaBean> findArea() {
        return stationAgentMapper.findArea();
    }

    @Override
    public Boolean addActionAgent(StationAgentBean stationAgent) {
        int count = stationAgentMapper.addActionAgent(stationAgent);
        if(count!=1) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public StationAgentBean findStationInfoById(Integer id) {
        return stationAgentMapper.findStationInfoById(id);
    }

    @Override
    public Boolean updateActionAgentById(StationAgentBean stationAgent) {
        return stationAgentMapper.updateActionAgentById(stationAgent);
    }

/*    @Override
    public HashMap<String, Object> findUserListAndOrderAndThoList(Integer page, Integer rows, OutBean outBean) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("outBean", outBean);//存入实体,用于写条查
        int total = stationAgentMapper.findOutCount(outBean);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<OutBean> list = stationAgentMapper.findOutPage(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public HashMap<String, Object> FindDetailsList(Integer page, Integer rows, TmoBean tmoBean) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("tmoBean", tmoBean);//存入实体,用于写条查
        int total = stationAgentMapper.findTmoCount(tmoBean);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<TmoBean> list = stationAgentMapper.findTmoPage(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public void upDateJu(String id) {
        stationAgentMapper.upDateJu(id);
    }

    @Override
    public void upDateJie(String id) {
        stationAgentMapper.upDateJie(id);
    }*/

}
