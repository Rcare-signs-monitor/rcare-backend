package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.PatientMapper;
import cn.edu.hit.rcare.pojo.Calling;
import cn.edu.hit.rcare.service.PatientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientFaceSeriveImpl implements PatientServer {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public void setCalling(Calling calling) {
        patientMapper.setface(calling);
    }

    @Override
    public Integer getCalling(Integer id) {
        return patientMapper.getface(id);
    }
}
