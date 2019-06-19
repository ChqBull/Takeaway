package com.jk.mapper.zc;


import com.jk.bean.MenuTree;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TreeMapper {
    @Select("select * from tree")
    List<MenuTree> findtree() ;

}
