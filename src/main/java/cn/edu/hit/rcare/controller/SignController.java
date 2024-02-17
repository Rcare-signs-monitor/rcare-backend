package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.pojo.Sign;
import cn.edu.hit.rcare.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SignController {

    @Autowired
    private SignService signService;

    @GetMapping("/signs/{id}")
    public Result list(@PathVariable Integer id, Integer num){
        log.info("查询成员 {} 的全部体征", id);
        List<Sign> signs = signService.list(id, num);
        return Result.success(signs);
    }

    @PostMapping("/signs")
    public Result add(@RequestBody Sign sign){
        log.info("新建体征记录: {}", sign);
        signService.add(sign);
        return Result.success();
    }
}
