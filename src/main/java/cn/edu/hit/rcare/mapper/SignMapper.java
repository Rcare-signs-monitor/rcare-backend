package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Sign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignMapper {
    List<Sign> list(Integer id, Integer num);

    @Insert("INSERT INTO sign " +
            "(heart_rate, respiratory_rate, systolic_pressure, diastolic_pressure, detection_time, member_id) VALUES " +
            "(#{heartRate}, #{respiratoryRate}, #{systolicPressure}, #{diastolicPressure}, #{detectionTime}, #{memberId})")
    void insert(Sign sign);
}
