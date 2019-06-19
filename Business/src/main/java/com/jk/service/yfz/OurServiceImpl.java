package com.jk.service.yfz;
import com.jk.bean.OutBean;
import com.jk.bean.TmoBean;
import com.jk.mapper.yfz.OutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class OurServiceImpl implements OutService {

    @Autowired
   OutMapper outMapper;

    @Override
    public HashMap<String, Object> findUserListAndOrderAndThoList(Integer page, Integer rows, OutBean outBean) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("outBean", outBean);//存入实体,用于写条查
        int total = outMapper.findOutCount(outBean);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<OutBean> list = outMapper.findOutPage(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public HashMap<String, Object> FindDetailsList(Integer page, Integer rows, TmoBean tmoBean) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        HashMap<String, Object> hashMap2 = new HashMap<>();
        //查询总条数
        hashMap2.put("tmoBean", tmoBean);//存入实体,用于写条查
        int total = outMapper.findTmoCount(tmoBean);
        //分页查询
        int start = (page - 1) * rows;//开始条数
        hashMap2.put("start", start);//到后台查询
        hashMap2.put("rows", rows);//到后台查询
        List<TmoBean> list = outMapper.findTmoPage(hashMap2);
        hashMap.put("total", total);//返回到前台
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public void upDateJu(String id) {
        outMapper.upDateJu(id);
    }

    @Override
    public void upDateJie(String id) {
        outMapper.upDateJie(id);
    }
}
