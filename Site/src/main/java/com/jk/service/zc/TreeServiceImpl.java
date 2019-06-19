package com.jk.service.zc;


import com.jk.bean.MenuTree;
import com.jk.mapper.zc.TreeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TreeServiceImpl  implements  TreeService{

    @Resource
    TreeMapper treeMapper;
    @Override
    public List<MenuTree> findtree() {
        return treeMapper.findtree();
    }
}
