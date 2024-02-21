package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
      log.info("文件上传：{}", image);

      String originalFilename = image.getOriginalFilename();
      String ext = originalFilename.substring(originalFilename.lastIndexOf('.'));
      String filename = UUID.randomUUID().toString() + ext;
      image.transferTo(new File("~\\rcare\\"+filename));

      return Result.success(filename);
    }
}
