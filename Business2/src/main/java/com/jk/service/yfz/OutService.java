package com.jk.service.yfz;

import com.jk.bean.OutBean;
import com.jk.bean.TmoBean;

import java.util.HashMap;

public interface OutService {

    HashMap<String, Object> findUserListAndOrderAndThoList();

    HashMap<String, Object> FindDetailsList(String orderNum);

    void upDateJu(String id);

    void upDateJie(String id);
}
