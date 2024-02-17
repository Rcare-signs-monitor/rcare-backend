package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.DistanceAngleMapper;
import cn.edu.hit.rcare.pojo.DistanceAngle;
import cn.edu.hit.rcare.service.DistanceAngleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceAngleServiceImpl implements DistanceAngleService {

    @Autowired
    private DistanceAngleMapper distanceAngleMapper;

    @Override
    public List<DistanceAngle> list(Integer num) {
        List<DistanceAngle> distanceAngles = distanceAngleMapper.list(num);
        return distanceAngles;
    }

    @Override
    public void add(DistanceAngle distanceAngle) {
        distanceAngleMapper.add(distanceAngle);
    }
}
