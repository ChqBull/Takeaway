package com.jk.service.chq;

import com.jk.mapper.chq.HorsemanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HorsemanServiceImpl implements HorsemanService{

    @Autowired
    HorsemanMapper horsemanMapper;

    @Override
    public HashMap<String, Object> findHorseman(Integer id) {
        return horsemanMapper.findHorseman(id);
    }
}
