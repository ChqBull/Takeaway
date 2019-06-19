package com.jk.mapper.gtf;

import com.jk.bean.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMapper {

    int count(@Param("store") Store store);

    List<Store> findStoreAll(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("store") Store store);

    Store findStoreById(@Param("store") Store store);

    List<Store> findArea();

    void addstore(@Param("store") Store store);

    void updstore(@Param("store") Store store);

    void delStore(@Param("store") Store store);
}
