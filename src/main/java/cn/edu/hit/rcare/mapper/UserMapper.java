package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(User user);
}
