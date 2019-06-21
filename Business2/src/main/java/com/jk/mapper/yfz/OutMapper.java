package com.jk.mapper.yfz;

import com.jk.bean.OutBean;
import com.jk.bean.TmoBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface OutMapper {

    List<OutBean> findOutPage();

    List<TmoBean> findTmoPage(@Param("orderNum") String orderNum);

    void upDateJu(String id);

    void upDateJie(String id);
}
