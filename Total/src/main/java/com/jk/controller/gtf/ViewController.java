package com.jk.controller.gtf;

import com.jk.bean.ViewPager;
import com.jk.service.gtf.ViewService;

import com.jk.utils.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    private ViewService viewService;

    @RequestMapping("viewpager")
    public String viewpager(){
        return "viewpager";
    }

    @RequestMapping("findViewPageAll")
    @ResponseBody
    public Map<String,Object> findViewPageAll(Integer start,Integer pageSize){
        return viewService.findViewPageAll(start,pageSize);
    }

    @RequestMapping("toAddViewPage")
    public String toAddViewPage(){
        return "addViewPage";
    }

    //上传
    @RequestMapping("imgUpload")
    @ResponseBody
    public  HashMap<String,Object> imgUpload(MultipartFile image){
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

    @RequestMapping("addViewPage")
    @ResponseBody
    public void addViewPage(ViewPager viewPager){
        viewService.addViewPage(viewPager);
    }

    @RequestMapping("delViewPage")
    @ResponseBody
    public void delViewPage(Integer id){
        viewService.delViewPage(id);
    }

    public String toUpdViewPage(){
        return "";
    }
}
