package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Member;
import cn.edu.hit.rcare.pojo.MemberSign;
import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public Result list(String name, Integer gender, Integer ageBegin, Integer ageEnd, String room, Integer num, String wid){
        log.info("条件查询所有成员: {} {} {} {} {} {}", name, gender, ageBegin, ageEnd, room, num, wid);
        if(num == null || num > 0){
            // ecg 永远返回 1024 条
            List<MemberSign> members = memberService.list(name, gender, ageBegin, ageEnd, room, num, wid);
            return Result.success(members);
        }else {
            // num = 0 时不返回 ecg
            List<MemberSign> members = memberService.listOnlyInfo(name, gender, ageBegin, ageEnd, room, wid);
            return Result.success(members);
        }
    }

    @GetMapping("/members/{id}")
    public Result searchById(@PathVariable Integer id){
        log.info("查询成员id{}", id);
        Member member = memberService.searchById(id);
        return Result.success(member);
    }

    @PostMapping("/members")
    public Result add(@RequestBody Member member){
        log.info("插入新成员: {}", member);
        memberService.add(member);
        return Result.success();
    }

    @PutMapping("/members")
    public Result update(@RequestBody Member member){
        log.info("更新成员: {}", member);
        memberService.update(member);
        return Result.success();
    }

    @DeleteMapping("/members/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除成员 id: {}", ids);
        memberService.delete(ids);
        return Result.success();
    }
}
