package cn.edu.hit.rcare.service;

import cn.edu.hit.rcare.pojo.RoomSign;

import java.util.List;
import java.util.Map;

public interface RoomService {
    Map<String, List<RoomSign>> list();
}
