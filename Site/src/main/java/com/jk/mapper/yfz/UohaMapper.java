package com.jk.mapper.yfz;

import com.jk.bean.UohaBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UohaMapper {
    /*财务信息查询总条数*/
    @Select("select count(1) from t_user tu,store s,t_order t ,horseman h,address a where t.address_id=a.id and t.user_id=tu.id and t.store_id=s.id")
    int findUohaCount(UohaBean uohaBean);

    List<UohaBean> findUohaPage(HashMap<String, Object> hashMap2);

    List<UohaBean> getWithdrawalRecordsIop(Integer companyId);

    /* *//*删除*//*
    @Delete("delete t_user tu where id = ${id} ")
    void deleteUoha(Integer id);*/
}
