package com.jk.mapper.zc;

import com.jk.bean.dingdan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ZcMappers {
    List<dingdan> finddingdan(@Param("id") Integer id, @Param("c") dingdan hs);

    long finddingdancount(@Param("id") Integer id);
    @Update("update t_order set horseStatus=2 where id=#{id}")
    void updatedaodian(Integer id);
    @Update("update t_order set horseStatus=3 where id=#{id}")
    void updatequcan(Integer id);
    @Update("update t_order set horseStatus=4 where id=#{id}")
    void updatesongda(Integer id);

    @Select("Select arriveStatus from horseman where id = #{id}")
    Integer workStatus(@Param("id") Integer id);

    @Update("update horseman set arriveStatus = 1 where id=#{id}")
    void applyingUpWork(@Param("id") Integer id);

    @Update("update horseman set arriveStatus = 1 where id=#{id}")
    void applyingDownWork(@Param("id") Integer id);
}
