package cn.edu.hit.rcare.service;

import cn.edu.hit.rcare.pojo.Sign;

import java.util.List;

public interface SignService {
    List<Sign> list(Integer id, Integer num);

    void add(Sign sign);
}
