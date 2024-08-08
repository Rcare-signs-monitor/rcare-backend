package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Calling;
import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.service.PatientServer;
import cn.edu.hit.rcare.service.impl.PatientFaceSeriveImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class FaceController {
    /***
     * 表情识别异常呼叫的接口
     ***/
    @Qualifier("patientFaceSeriveImpl")
    @Autowired
    private PatientServer patientServer;

    @PostMapping("/face")
    public Result calling(@RequestBody Calling calling){
        patientServer.setCalling(calling);
        return Result.success();
    }

    @GetMapping("/face/{id}")
    public Result query(@PathVariable Integer id){
        Integer res = patientServer.getCalling(id);
        return Result.success(res);
    }
    /**
     * @param image 图像识别结果上传
     * @return
     * @throws IOException
     */
    @PostMapping("/face/img")
    public Result upload_img(MultipartFile image) throws IOException {
        log.info("文件上传：{}", image);

        String filename = "temperature.jpg";
        image.transferTo(new File("/home/ubuntu/rcare/"+filename));

        return Result.success(filename);
    }
}
