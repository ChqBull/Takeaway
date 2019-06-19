package com.jk.mapper.yfz;

import com.jk.bean.HorsemanBean;
import com.jk.bean.OrderBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface OrderMapper {
    /*订单状态查询总条数 状态是1 写死*/
    @Select("select count(1) from t_order o where o.orderStatus=1 and o.horseStatus = 0")
    int findOrderCount(OrderBean orderBean);

    List<OrderBean> findOrderPage(HashMap<String, Object> hashMap2);

    /*查询在线骑手*/
    List<HorsemanBean> findHorsemanPage();

    /*查询骑手身上订单数*/
    Integer findHorsemanCount(Integer id);

    void addOrderHoresman(@Param("split") String[] split,@Param("horesmanId") Integer horesmanId);

    void updateZhiPai(@Param("split") String split);

    List<HorsemanBean>  findHorsemanStatus();

}
