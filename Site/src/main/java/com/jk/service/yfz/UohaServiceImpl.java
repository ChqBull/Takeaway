package com.jk.service.yfz;
import com.jk.bean.UohaBean;
import com.jk.mapper.yfz.UohaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UohaServiceImpl implements UohaService{

    @Autowired
    UohaMapper uohaMapper;

    @Override
    public HashMap<String, Object> findUohaList(Integer page, Integer rows, UohaBean uohaBean) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("uohaBean", uohaBean);//存入实体,用于写条查
        int total = uohaMapper.findUohaCount(uohaBean);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<UohaBean> list = uohaMapper.findUohaPage(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public List<UohaBean> getWithdrawalRecordsIop(Integer companyId) {
        List<UohaBean> list = uohaMapper.getWithdrawalRecordsIop(companyId);
        return list;
    }

    /*@Override
    public void deleteUoha(Integer id) {
        uohaMapper.deleteUoha(id);
    }*/
}
