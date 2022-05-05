package com.example.demo.services;

import com.example.demo.mapper.WinnerMapper;
import com.example.demo.pojo.Winner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WinnerServiceImpl implements WinnerService{
    @Autowired
    WinnerMapper winnerMapper;
    @Override
    public List<Winner> winnerList() {
        return winnerMapper.winnerList();
    }

    @Override
    public int winInsert(Map<String, Object> map) {
        return winnerMapper.winInsert(map);
    }
}
