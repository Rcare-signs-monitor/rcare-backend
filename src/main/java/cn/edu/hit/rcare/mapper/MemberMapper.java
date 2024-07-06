package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Member;
import cn.edu.hit.rcare.pojo.MemberSign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {


    /**
     * 条件查询病患列表
     * @param name 病患姓名
     * @param gender 病患性别
     * @param ageBegin 最小年龄
     * @param ageEnd 最大年龄
     * @param room 病房号
     * @return 病患列表
     */
    List<MemberSign> list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String room, String wid);


    /**
     * 按 id 查询病患个人信息
     * @param id 病患id
     * @return
     */
    @Select("select id, room, bed, name, gender, age, doctor, day, result, allergy, " +
            "healing, contact, attention, image, openid " +
            "from member join room_bed_member rbm on member.id = rbm.member_id " +
            "where id=#{id}")
    Member searchById(Integer id);

    /**
     * 插入新成员信息
     * @param member
     */

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

    List<MemberSign> list_new(String name, Integer gender, Integer ageBegin, Integer ageEnd, String room, Integer num, String wid);

    @Select("SET SESSION group_concat_max_len = #{value}")
    void setGroupConcatMaxLen(int value);
}
