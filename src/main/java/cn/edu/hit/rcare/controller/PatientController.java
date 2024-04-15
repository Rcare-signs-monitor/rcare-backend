package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Calling;
import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.pojo.SignPost;
import cn.edu.hit.rcare.service.PatientServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PatientController {
    /***
     * 给患者客户端的接口，实现呼叫功能
     ***/
    @Autowired
    private PatientServer patientServer;

    @PostMapping("/calling")
    public Result calling(@RequestBody Calling calling){
        patientServer.setCalling(calling);
        return Result.success();
    }

    @GetMapping("/calling/{id}")
    public Result query(@PathVariable Integer id){
        Integer res = patientServer.getCalling(id);
        return Result.success(res);
    }
}
