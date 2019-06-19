package com.jk.service.yfz;

import com.jk.bean.UohaBean;

import java.util.HashMap;
import java.util.List;

public interface UohaService {
    HashMap<String, Object> findUohaList(Integer page, Integer rows, UohaBean uohaBean);

    List<UohaBean> getWithdrawalRecordsIop(Integer companyId);

    /* void deleteUoha(Integer id);*/
}
