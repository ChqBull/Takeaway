package com.jk.mapper.chq;

import com.jk.bean.Area;

import com.jk.bean.address;
import com.jk.bean.menuBean;
import com.jk.bean.menuType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChqMapper{

    @Select("select * from area")
    List<Area> findArea();
    @Select("select * from menu_type")
    List<menuType> findmenuType();
    @Select("select * from menu where store_id = #{id} ")
    List<menuBean> findMenue(@Param("id") String id);
    @Select("select * from menu where store_id = #{id} and type_id= #{typeId}")
    List<menuBean> findMenuetypeId(@Param("id")String id,@Param("typeId") String typeId);

    void add(@Param("area") String area,@Param("id") Integer phoneNumber);
    @Select("select * from address  where user_id = #{id}")
    List<address> queryUserArea(@Param("id") Integer phoneNumber);

    void addOrder(@Param("dateTime") long dateTime,@Param("userid") Integer userid,
                  @Param("storeid") String storeid,@Param("price") String price,
                  @Param("msg") String msg,@Param("area") String area);

    void addOm(@Param("dateTime") long dateTime, @Param("split") String split, @Param("count") String count);

    menuBean chakanxiangqing(@Param("id") Integer id,@Param("storeid") Integer storeid);
}
