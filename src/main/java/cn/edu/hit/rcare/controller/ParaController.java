package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Para;
import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.service.ParaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ParaController {

    @Autowired
    private ParaService paraService;

    @GetMapping("/paras")
    public Result get(){
        log.info("获取参数");
        Para para = paraService.get();
        return Result.success(para);
    }

    @PostMapping("/paras")
    public Result set(@RequestBody Para para){
        log.info("设置参数 {}", para);
        paraService.set(para);
        return Result.success();
    }
}
