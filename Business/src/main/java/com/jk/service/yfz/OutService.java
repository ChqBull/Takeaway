package com.jk.service.yfz;

import com.jk.bean.OutBean;
import com.jk.bean.TmoBean;

import java.util.HashMap;

public interface OutService {

    HashMap<String, Object> findUserListAndOrderAndThoList(Integer page, Integer rows, OutBean outBean);

    HashMap<String, Object> FindDetailsList(Integer page, Integer rows, TmoBean tmoBean);

    void upDateJu(String id);

    void upDateJie(String id);
}
