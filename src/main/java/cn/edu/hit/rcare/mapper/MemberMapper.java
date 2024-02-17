package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String address);

    @Insert("INSERT INTO member (name, gender, age, address) VALUES " +
            "(#{name}, #{gender}, #{age}, #{address})")
    void insert(Member member);

    void update(Member member);

    void delete(List<Integer> ids);
}
