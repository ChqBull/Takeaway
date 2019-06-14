package com.jk.rmi.chq;

import com.jk.bean.StoreBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@FeignClient("USERORDER")
public interface OrderClient {

    @RequestMapping("findBusiness")
    HashMap<String, Object> findBusiness(@RequestParam("start") Integer start, @RequestParam("pageSize") Integer pageSize, @RequestBody StoreBean storeBean);
}
