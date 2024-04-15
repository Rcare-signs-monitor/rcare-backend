package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.pojo.Room;
import cn.edu.hit.rcare.pojo.RoomSign;
import cn.edu.hit.rcare.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public Result list(){
        log.info("查询病房占用信息");
        Map<String, List<RoomSign>> rooms = roomService.list();
        return Result.success(rooms);
    }
}
