package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.RoomMapper;
import cn.edu.hit.rcare.mapper.SignMapper;
import cn.edu.hit.rcare.pojo.*;
import cn.edu.hit.rcare.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    /**
     * 主页需要的信息
     * @return
     */
    @Override
    public Map<String, List<RoomSign>> list() {
        // 按病房号分组
        List<RoomSign> roomSigns = roomMapper.list();
        Map<String, List<RoomSign>> roomListMap = new HashMap<>();
        for (RoomSign roomSign : roomSigns) {
            roomListMap.computeIfAbsent(roomSign.getRoom(), k -> new ArrayList<>()).add(roomSign);
        }
        return roomListMap;
    }
}
