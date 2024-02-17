package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.MemberMapper;
import cn.edu.hit.rcare.pojo.Member;
import cn.edu.hit.rcare.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String address) {
        return memberMapper.list(name, gender, ageBegin, ageEnd, address);
    }

    @Override
    public void add(Member member) {
        memberMapper.insert(member);
    }

    @Override
    public void update(Member member) {
        memberMapper.update(member);
    }

    @Override
    public void delete(List<Integer> ids) {
        memberMapper.delete(ids);
    }
}
