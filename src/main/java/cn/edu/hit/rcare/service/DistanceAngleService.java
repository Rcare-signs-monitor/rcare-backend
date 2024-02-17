package cn.edu.hit.rcare.service;

import cn.edu.hit.rcare.pojo.DistanceAngle;

import java.util.List;

public interface DistanceAngleService {
    List<DistanceAngle> list(Integer num);

    void add(DistanceAngle distanceAngle);
}
