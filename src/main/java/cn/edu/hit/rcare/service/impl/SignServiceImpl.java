package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.SignMapper;
import cn.edu.hit.rcare.pojo.Sign;
import cn.edu.hit.rcare.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    @Override
    public List<Sign> list(Integer id, Integer num) {
        List<Sign> signs = signMapper.list(id, num);
        return signs;
    }

    @Override
    public void add(Sign sign) {
        signMapper.insert(sign);
    }
}
