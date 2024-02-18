package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.UserMapper;
import cn.edu.hit.rcare.pojo.User;
import cn.edu.hit.rcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {

        return userMapper.getByUsernameAndPassword(user);
    }
}
