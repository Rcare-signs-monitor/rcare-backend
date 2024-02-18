package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.ParaMapper;
import cn.edu.hit.rcare.pojo.Para;
import cn.edu.hit.rcare.service.ParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParaServiceImpl implements ParaService {
    @Autowired
    private ParaMapper paraMapper;

    @Override
    public Para get() {
        return paraMapper.get();
    }

    @Override
    public void set(Para para) {
        paraMapper.set(para);
    }
}
