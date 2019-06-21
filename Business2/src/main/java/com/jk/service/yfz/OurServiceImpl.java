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
    public HashMap<String, Object> findUserListAndOrderAndThoList() {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        List<OutBean> list = outMapper.findOutPage();
        hashMap.put("rows", list);//返回到前台
        return hashMap;
    }

    @Override
    public HashMap<String, Object> FindDetailsList(String orderNum) {
        HashMap<String, Object> hashMap = new HashMap<>();//相当于原来的封装类
        List<TmoBean> list = outMapper.findTmoPage(orderNum);
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
