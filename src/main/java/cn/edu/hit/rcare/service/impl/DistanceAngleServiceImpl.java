package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.DistanceAngleMapper;
import cn.edu.hit.rcare.pojo.DistanceAngle;
import cn.edu.hit.rcare.pojo.DistanceAnglePost;
import cn.edu.hit.rcare.service.DistanceAngleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceAngleServiceImpl implements DistanceAngleService {

    @Autowired
    private DistanceAngleMapper distanceAngleMapper;

    @Override
    public List<DistanceAngle> list(Integer member_id, Integer num) {
        List<DistanceAngle> distanceAngles = distanceAngleMapper.list(member_id, num);
        return distanceAngles;
    }

    @Override
    public void add(DistanceAnglePost distanceAngle) {
        distanceAngleMapper.add(distanceAngle);
    }
}
