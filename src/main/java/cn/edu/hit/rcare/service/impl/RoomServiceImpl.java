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
    @Autowired
    private SignMapper signMapper;

    /**
     * 主页需要的信息
     * @return
     */
    @Override
    public Map<String, List<RoomSign>> list() {
        Map<String, List<RoomSign>> room_list = new HashMap<>();
        List<String> room_id_list = roomMapper.getRoomId();
        room_id_list.forEach(room_id -> {
            List<Room> rooms = roomMapper.getRoomsById(room_id);
            List<RoomSign> roomSigns = new ArrayList<>();
            rooms.forEach(room -> {
                if(room.getId() == null){
                    roomSigns.add(new RoomSign(room_id, room.getBed(), null, null, null));
                }
                else {
                    List<Sign> tmp = signMapper.list(room.getId(), 1, "heart");
                    Sign heart = tmp.size() > 0 ? tmp.get(0) : null;
                    tmp = signMapper.list(room.getId(), 1, "respire");
                    Sign respire = tmp.size() > 0 ? tmp.get(0) : null;
                    tmp = signMapper.list(room.getId(), 1, "sbp");
                    Sign sbp = tmp.size() > 0 ? tmp.get(0) : null;
                    tmp = signMapper.list(room.getId(), 1, "dbp");
                    Sign dbp = tmp.size() > 0 ? tmp.get(0) : null;
                    tmp = signMapper.list(room.getId(), 1, "ecg");
                    Sign ecg = tmp.size() > 0 ? tmp.get(0) : null;
                    Signs signs = new Signs(heart, respire, sbp, dbp, ecg);
                    roomSigns.add(new RoomSign(room_id, room.getBed(), room.getId(), room.getName(), signs));
                }
            });
            room_list.put(room_id, roomSigns);
        });
        return room_list;
    }
}
