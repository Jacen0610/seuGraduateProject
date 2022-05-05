package com.example.demo.services;

import com.example.demo.pojo.Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InfoService {
    List<Info> getInfoList();
    List<Info> getInfoListIf(Map map);
    Info getInfoById(Integer id);

    int addInfo(Map<String,Object> map);

    @Delete("delete from info where id=#{id}")
    int deleteInfo(@Param("id") int id);

    int updateInfo(Map<String,Object> map);
}
