package com.example.demo.services;

import com.example.demo.pojo.Winner;

import java.util.List;
import java.util.Map;

public interface WinnerService {
    List<Winner> winnerList();

    int winInsert(Map<String,Object> map);
}
