package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.DistanceAngle;
import cn.edu.hit.rcare.pojo.DistanceAnglePost;
import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.service.DistanceAngleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DistanceAngleController {

    @Autowired
    private DistanceAngleService distanceAngleService;

    @GetMapping("/distance_angles/{member_id}")
    public Result list(@PathVariable Integer member_id, Integer num){
        log.info("查询距离角度：{} - {}条", member_id, num);
        List<DistanceAngle> distanceAngles = distanceAngleService.list(member_id, num);
        return Result.success(distanceAngles);
    }

    @PostMapping("/distance_angles")
    public Result add(@RequestBody DistanceAnglePost distanceAngle){
        log.info("添加距离角度记录：{}", distanceAngle);
        distanceAngleService.add(distanceAngle);
        return Result.success();
    }
}
