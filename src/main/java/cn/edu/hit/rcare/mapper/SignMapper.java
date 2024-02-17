package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Sign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignMapper {
    /**
     * 查询成员为id的num条体征信息
     * @param id 成员id
     * @param num 信息条数
     * @return
     */
    List<Sign> list(Integer id, Integer num);

    /**
     * 新增一条体征记录
     * @param sign
     */
    @Insert("INSERT INTO sign " +
            "(heart_rate, respiratory_rate, systolic_pressure, diastolic_pressure, detect_time, member_id) VALUES " +
            "(#{heartRate}, #{respiratoryRate}, #{systolicPressure}, #{diastolicPressure}, #{detectTime}, #{memberId})")
    void insert(Sign sign);
}
