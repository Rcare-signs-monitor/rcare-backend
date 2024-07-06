package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.MemberMapper;
import cn.edu.hit.rcare.mapper.RoomMapper;
import cn.edu.hit.rcare.mapper.SignMapper;
import cn.edu.hit.rcare.pojo.*;
import cn.edu.hit.rcare.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private SignMapper signMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<MemberSign> list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String room, Integer num, String wid) {
//        List<Member> members = memberMapper.list(name, gender, ageBegin, ageEnd, room, num, wid);
//        List<MemberSign> memberSigns = new ArrayList<>();
//        members.forEach(item -> {
//            Integer id = item.getId();
//            List<Sign> tmp = signMapper.list(id, num, "heart");
//            List<Sign> heart = tmp.size() > 0 ? tmp : null;
//            tmp = signMapper.list(id, num, "respire");
//            List<Sign> respire = tmp.size() > 0 ? tmp : null;
//            tmp = signMapper.list(id, num, "sbp");
//            List<Sign> sbp = tmp.size() > 0 ? tmp : null;
//            tmp = signMapper.list(id, num, "dbp");
//            List<Sign> dbp = tmp.size() > 0 ? tmp : null;
//            tmp = signMapper.list(id, 1024, "ecg");
//            List<Sign> ecg = tmp.size() > 0 ? tmp : null;
//            List<Status> statusList = signMapper.status(id);
//            Status status = statusList.size() > 0 ? statusList.get(0) : null;
//            SignsList signs = new SignsList(heart, respire, sbp, dbp, ecg, status);
//            memberSigns.add(new MemberSign(item, signs));
//        });

        /* 优化查询性能 */
        memberMapper.setGroupConcatMaxLen(1000000);
        List<MemberSign> memberSigns = memberMapper.list_new(name, gender, ageBegin, ageEnd, room, num, wid);
        return  memberSigns;
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
        roomMapper.delete(ids);
    }

    @Override
    public Member searchById(Integer id) {
        return memberMapper.searchById(id);
    }

    @Override
    public List<MemberSign> listOnlyInfo(String name, Integer gender, Integer ageBegin, Integer ageEnd, String room, String wid) {
        return memberMapper.list(name, gender, ageBegin, ageEnd, room, wid);
    }
}
