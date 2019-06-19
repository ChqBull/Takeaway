package com.jk.controller.gtf;

import com.jk.bean.Store;
import com.jk.service.gtf.StoreService;
import com.jk.utils.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("findStoreAll")
    @ResponseBody
    public Map<String,Object> findStoreAll(Integer start, Integer pageSize, Store store){
        return storeService.findStoreAll(start,pageSize,store);
    }

    @RequestMapping("findArea")
    @ResponseBody
    public List<Store> findArea(){
        return storeService.findArea();
    }

    //上传
    @RequestMapping("imgUpload")
    @ResponseBody
    public HashMap<String,Object> imgUpload(MultipartFile image){
        String filename = image.getOriginalFilename();
        HashMap<String, Object> map = new HashMap<>();
        try {
            if (image != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(image.getBytes());
                    os.close();
                    image.transferTo(newFile);
                    // 上传到OSS
                    String uploadUrl = AliyunOSSUtil.upLoad(newFile);
                    map.put("imgId",uploadUrl);
                    return  map;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        map.put("imgId","");
        return  map;
    }

    @RequestMapping("addstore")
    @ResponseBody
    public void addstore(Store store){
        storeService.addstore(store);
    }

    @RequestMapping("updstore")
    @ResponseBody
    public void updstore(Store store){
        storeService.updstore(store);
    }

    @RequestMapping("delStore")
    @ResponseBody
    public void delStore(Store store){
        storeService.delStore(store);
    }
}
