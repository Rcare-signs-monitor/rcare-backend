package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    /**
     * 条件查询全部成员信息
     * @param name 姓名
     * @param gender 性别 0女1男
     * @param ageBegin 最小年龄
     * @param ageEnd 最大年龄
     * @param address 地址
     * @return
     */
    List<Member> list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String address);

    /**
     * 按id查询成员
     * @param id
     * @return
     */
    @Select("SELECT * FROM member where id=#{id}")
    Member searchById(Integer id);

    /**
     * 插入新成员信息
     * @param member
     */
    @Insert("INSERT INTO member (name, gender, age, address) VALUES " +
            "(#{name}, #{gender}, #{age}, #{address})")
    void insert(Member member);

    /**
     * 更新成员信息
     * @param member
     */
    void update(Member member);

    /**
     * 按ids列表删除成员
     * @param ids
     */
    void delete(List<Integer> ids);
}
