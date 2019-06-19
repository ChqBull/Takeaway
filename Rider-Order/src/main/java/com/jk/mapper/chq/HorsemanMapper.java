package com.jk.mapper.chq;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface HorsemanMapper {
    HashMap<String, Object> findHorseman(Integer id);
}
