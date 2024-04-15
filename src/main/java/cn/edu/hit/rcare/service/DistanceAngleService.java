package cn.edu.hit.rcare.service;

import cn.edu.hit.rcare.pojo.DistanceAngle;
import cn.edu.hit.rcare.pojo.DistanceAnglePost;

import java.util.List;

public interface DistanceAngleService {
    List<DistanceAngle> list(Integer member_id, Integer num);

    void add(DistanceAnglePost distanceAngle);
}
