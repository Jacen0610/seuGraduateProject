package com.example.demo.services;

import com.example.demo.pojo.Join;

import java.util.List;
import java.util.Map;

public interface JoinService {

    List<Join> getJoinList();

    Join getJoinListByJid(Integer id);

    List<Join> getJoinListByInfoNo(Integer id);

    Join getTheHighestScore(Integer id);

    int joinInsert(Map<String,Object> map);

    int updateJoin(Map<String,Object> map);
}
