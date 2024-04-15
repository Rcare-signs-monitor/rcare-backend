package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.DistanceAngle;
import cn.edu.hit.rcare.pojo.DistanceAnglePost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DistanceAngleMapper {

    /**
     * 查询距离角度记录
     * @param num 查询记录数
     * @return
     */
    List<DistanceAngle> list(Integer member_id, Integer num);

    /**
     * 新增距离角度记录
     * @param distanceAngle
     */
    @Insert("INSERT INTO distance_angle " +
            "(member_id, time, distance, angle) VALUES " +
            "(#{member_id}, now(), #{distance}, #{angle})")
    void add(DistanceAnglePost distanceAngle);
}
