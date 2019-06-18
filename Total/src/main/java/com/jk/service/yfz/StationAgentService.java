package com.jk.service.yfz;

import com.jk.bean.AreaBean;
import com.jk.bean.OutBean;
import com.jk.bean.StationAgentBean;
import com.jk.bean.TmoBean;

import java.util.HashMap;
import java.util.List;

public interface StationAgentService {
    HashMap<String, Object> findStationAgentList(Integer page, Integer rows, StationAgentBean stationAgent);

    void deleteStationAgent(Integer id);

    List<AreaBean> findArea();

    Boolean addActionAgent(StationAgentBean stationAgent);

    StationAgentBean findStationInfoById(Integer id);

    Boolean updateActionAgentById(StationAgentBean stationAgent);

   /* HashMap<String, Object> findUserListAndOrderAndThoList(Integer page, Integer rows, OutBean outBean);

    HashMap<String, Object> FindDetailsList(Integer page, Integer rows, TmoBean tmoBean);

    void upDateJu(String id);

    void upDateJie(String id);*/
}
