package cn.edu.hit.rcare.service;

import cn.edu.hit.rcare.pojo.Member;

import java.util.List;

public interface MemberService {
    List<Member> list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String address);

    void add(Member member);

    void update(Member member);

    void delete(List<Integer> ids);

    Member searchById(Integer id);
}
