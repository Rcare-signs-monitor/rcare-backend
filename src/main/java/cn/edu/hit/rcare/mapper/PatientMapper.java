package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Calling;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PatientMapper {
    @Update("update sign_table_temp set calling=#{data} where member_id=#{id}")
    void set(Calling calling);

    @Select("select calling from sign_table_temp where member_id=#{id}")
    Integer get(Integer id);

    @Update("update sign_table_temp set face=#{data} where member_id=#{id}")
    void setface(Calling calling);

    @Select("select face from sign_table_temp where member_id=#{id}")
    Integer getface(Integer id);
}
