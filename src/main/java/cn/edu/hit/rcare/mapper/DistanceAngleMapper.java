package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.DistanceAngle;
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
    List<DistanceAngle> list(Integer num);

    /**
     * 新增距离角度记录
     * @param distanceAngle
     */
    @Insert("INSERT INTO distance_angle " +
            "(detect_time, distance, angle) VALUES " +
            "(#{detectTime}, #{distance}, #{angle})")
    void add(DistanceAngle distanceAngle);
}
