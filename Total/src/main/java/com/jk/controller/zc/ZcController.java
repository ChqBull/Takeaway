package com.jk.controller.zc;

import com.alibaba.fastjson.JSON;
import com.jk.bean.MenuBean;
import com.jk.bean.horseman;
import com.jk.bean.store;
import com.jk.service.zc.ZcService;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ZcController {

    @Resource
    ZcService zcService;

    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping("findqishou")
    @ResponseBody
    public HashMap<String,Object> findqishou(Integer pageSize, Integer start, horseman hs){
            HashMap<String, Object> map = zcService.findqishou(pageSize, start, hs);
            return map;
    }
    @RequestMapping("findcaidan")
    @ResponseBody
    public HashMap<String,Object> findcaidan(Integer pageSize, Integer start, MenuBean hs){
        HashMap<String, Object> map = zcService.findcaidan(pageSize, start, hs);
        return map;
    }

    @RequestMapping("updateshenhe")
    @ResponseBody
    public void updateshenhe(Integer id){
        zcService.updateshenhe(id);
    }
    @RequestMapping("finddianpu")
    @ResponseBody
    public HashMap<String,Object> finddianpu(Integer pageSize, Integer start, store hs){

        ValueOperations ops = redisTemplate.opsForValue();
        Object o = ops.get("zc"+start);
        //Object o = ops.get(start);
        if(o==null){
            HashMap<String, Object> map = zcService.finddianpu(pageSize, start, hs);
            ops.set("zc"+start,map,30, TimeUnit.SECONDS);
            return map;
        }else {
            return (HashMap<String, Object>) o;
        }
    }

    @RequestMapping("updatedianmian")
    @ResponseBody
    public void updatedianmian(Integer id){
        zcService.updatedianmian(id);

    }
    @RequestMapping("updatecaidan")
    @ResponseBody
    public void updatecaidan(Integer id){
        zcService.updatecaidan(id);

    }
}
