package com.example.demo.services;

import com.example.demo.mapper.JoinMapper;
import com.example.demo.pojo.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JoinServiceImpl implements JoinService{
    @Autowired
    JoinMapper joinMapper;

    @Override
    public List<Join> getJoinList() {
        return joinMapper.getJoinList();
    }

    @Override
    public Join getJoinListByJid(Integer id) {
        return joinMapper.getJoinListByJid(id);
    }

    @Override
    public List<Join> getJoinListByInfoNo(Integer id) {
        return joinMapper.getJoinListByInfoNo(id);
    }

    @Override
    public Join getTheHighestScore(Integer id) {
        return joinMapper.getTheHighestScore(id);
    }

    @Override
    public int joinInsert(Map<String, Object> map) {
        return joinMapper.joinInsert(map);
    }

    @Override
    public int updateJoin(Map<String, Object> map) {
        return joinMapper.updateJoin(map);
    }
}
