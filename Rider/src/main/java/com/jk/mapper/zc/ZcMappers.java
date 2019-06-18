package com.jk.mapper.zc;

import com.jk.bean.dingdan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ZcMappers {
    List<dingdan> finddingdan(@Param("pageSize") Integer pageSize, @Param("start")Integer start,@Param("c") dingdan hs);

    long finddingdancount(@Param("pageSize") Integer pageSize, @Param("start")Integer start);
    @Update("update t_order set horseStatus=2 where id=#{id}")
    void updatedaodian(Integer id);
    @Update("update t_order set horseStatus=3 where id=#{id}")
    void updatequcan(Integer id);
    @Update("update t_order set horseStatus=4 where id=#{id}")
    void updatesongda(Integer id);
}
