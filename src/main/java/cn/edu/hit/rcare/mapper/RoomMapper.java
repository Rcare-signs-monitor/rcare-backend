package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomMapper {
    /**
     * 查询所有病房号
     * @return
     */
    @Select("select distinct room from room_bed_member")
    List<String> getRoomId();

    /**
     * 按病房号查询：病房-床号-病患
     * @param id
     * @return
     */
    @Select("select room, bed, member_id as id, name " +
            "from room_bed_member left join member on room_bed_member.member_id = member.id " +
            "where room=#{id}")
    List<Room> getRoomsById(String id);

    void delete(List<Integer> ids);
}
