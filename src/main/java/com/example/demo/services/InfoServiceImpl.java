package com.example.demo.services;

import com.example.demo.mapper.InfoMapper;
import com.example.demo.pojo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    InfoMapper infoMapper;


    @Override
    public List<Info> getInfoList() {
        return infoMapper.getInfoList();
    }

    @Override
    public List<Info> getInfoListIf(Map map) {
        return infoMapper.getInfoListIf(map);
    }

    @Override
    public Info getInfoById(Integer id){
        return infoMapper.getInfoById(id);
    }

    @Override
    public int addInfo(Map<String, Object> map) {
        return infoMapper.addInfo(map);
    }

    @Override
    public int deleteInfo(int id) {
        return infoMapper.deleteInfo(id);
    }

    @Override
    public int updateInfo(Map<String, Object> map) {
        return infoMapper.updateInfo(map);
    }
}
