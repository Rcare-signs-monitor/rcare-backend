package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.RoomSign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomMapper {
    void delete(List<Integer> ids);

    List<RoomSign> list();
}
