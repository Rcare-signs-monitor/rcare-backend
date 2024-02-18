package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Result;
import cn.edu.hit.rcare.pojo.User;
import cn.edu.hit.rcare.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("用户登录");
        User u = userService.login(user);
        return u != null? Result.success() : Result.error("登录失败，账号或者密码错误");
    }
}
