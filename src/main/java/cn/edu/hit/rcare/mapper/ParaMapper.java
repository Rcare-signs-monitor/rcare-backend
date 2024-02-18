package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Para;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ParaMapper {
    @Select("select * from para limit 1")
    Para get();

    @Update("UPDATE para SET para1=#{para1}, para2=#{para2}")
    void set(Para para);
}
