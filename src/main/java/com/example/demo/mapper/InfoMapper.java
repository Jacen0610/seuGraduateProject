package com.example.demo.mapper;

import com.example.demo.pojo.Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Component
public interface InfoMapper {

    List<Info> getInfoList();
    List<Info> getInfoListIf(Map map);
    Info getInfoById(Integer id);

    int addInfo(Map<String,Object> map);

    @Delete("delete from info where infoid=#{id}")
    int deleteInfo(@Param("id") int id);

    int updateInfo(Map<String,Object> map);
}
