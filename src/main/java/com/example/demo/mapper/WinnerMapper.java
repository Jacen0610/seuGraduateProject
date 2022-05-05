package com.example.demo.mapper;

import com.example.demo.pojo.Winner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface WinnerMapper {

    List<Winner> winnerList();

    int winInsert(Map<String,Object> map);
}
