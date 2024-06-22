package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SignMapper {
    /**
     * 查询成员为id的num条体征信息
     * @param id 成员id
     * @param num 信息条数
     * @return
     */
    List<Sign> list(Integer id, Integer num, String type);

    /**
     * 新增一条体征记录
     * @param sign
     */
    @Insert("INSERT INTO sign " +
            "(member_id, time, type, data) VALUES " +
            "(#{member_id}, now(), #{type}, #{data})")
    void insert(SignPost sign);


    /**
     * 按 id 查询体征信息，表格形式返回
     * @param id
     * @param num
     * @return
     */
    List<SignTable> listTable(Integer id, Integer num);


    /**
     * 更新临时表，同步插入到体征历史表
     * @param sign
     */
    @Update("update sign_table_temp set time=now(), ${type}=#{data} where member_id=#{member_id}")
    void updateTmpTable(SignPost sign);
    @Insert("insert into sign_table(member_id, time, heart, respire, sbp, dbp) " +
            "select member_id, time, heart, respire, sbp, dbp from sign_table_temp where member_id=#{member_id}")
    void insertTable(SignPost sign);

    @Select("select chest_pain, exercise_angina, heart_disease from sign_table_temp where member_id=#{member_id}")
    List<Status> status(Integer id);

    void insert4ecg(SignPostEcg ecg);
}
