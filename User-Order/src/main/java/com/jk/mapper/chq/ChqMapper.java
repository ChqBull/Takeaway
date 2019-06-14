package com.jk.mapper.chq;

import com.jk.bean.StoreBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChqMapper {

    Long findBusinessCount();

    List<StoreBean> findBusiness(@Param("page") Integer page,@Param("limit") Integer limit,@Param("storeBean") StoreBean storeBean);
}
