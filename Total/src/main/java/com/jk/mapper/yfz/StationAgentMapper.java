package com.jk.mapper.yfz;

import com.jk.bean.AreaBean;
import com.jk.bean.OutBean;
import com.jk.bean.StationAgentBean;
import com.jk.bean.TmoBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface StationAgentMapper {
    /*站长查询总条数*/
    @Select("select count(1) from station_agent sa")
    int findStationAgentCount(StationAgentBean stationAgent);

    List<StationAgentBean> findStationAgentPage(HashMap<String, Object> hashMap2);

    void deleteStationAgent(Integer id);

    /*查询地区*/
    @Select("select * from area")
    List<AreaBean> findArea();

    /*站长新增*/
    @Insert("insert into station_agent(stationName,password,startTime,area_id) values(#{stationName},#{password},#{startTime},#{area_id})")
    int addActionAgent(StationAgentBean stationAgent);

    /*根据ID查询修改 回显*/
    @Select("select * from station_agent where id=#{value}")
    StationAgentBean findStationInfoById(Integer id);

    /*修改*/
    @Update("update station_agent set stationName=#{stationName},password=#{password},startTime=#{startTime},area_id=#{area_id} where id=#{id}")
    Boolean updateActionAgentById(StationAgentBean stationAgent);

    /*  *//*用户登录查询总条数*//*
    @Select("select count(1) from horseman ho , t_order o ,t_user tu , t_o_h oh where o.user_id = tu.id and oh.horseman_id = ho.id and oh.orderNum = o.orderNum and o.store_id = '2'")
    int findOutCount(OutBean outBean);

    List<OutBean> findOutPage(HashMap<String, Object> hashMap2);
    *//*查看详情总条数*//*
    @Select("SELECT count(1) from t_o_m om , menu me where om.orderNum = '12332423' and om.menu_id = me.id")
    int findTmoCount(TmoBean tmoBean);

    List<TmoBean> findTmoPage(HashMap<String, Object> hashMap2);

    void upDateJu(String id);

    void upDateJie(String id);*/


}
