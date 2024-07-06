package cn.edu.hit.rcare.service;

import cn.edu.hit.rcare.pojo.Member;
import cn.edu.hit.rcare.pojo.MemberSign;

import java.util.List;

public interface MemberService {
    List<MemberSign> list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String room, Integer num, String wid);

    void add(Member member);

    void update(Member member);

    void delete(List<Integer> ids);

    Member searchById(Integer id);

    List<MemberSign> listOnlyInfo(String name, Integer gender, Integer ageBegin, Integer ageEnd, String room, String wid);
}
