package com.example.demo.mapper;

import com.example.demo.pojo.Join;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface JoinMapper {

    List<Join> getJoinList();

    List<Join> getJoinListByInfoNo(Integer id);

    Join getJoinListByJid(Integer id);

    Join getTheHighestScore(Integer id);

    int joinInsert(Map<String,Object> map);

    int updateJoin(Map<String,Object> map);

}
