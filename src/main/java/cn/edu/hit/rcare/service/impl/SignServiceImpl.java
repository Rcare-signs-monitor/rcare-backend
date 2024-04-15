package cn.edu.hit.rcare.service.impl;

import cn.edu.hit.rcare.mapper.SignMapper;
import cn.edu.hit.rcare.pojo.*;
import cn.edu.hit.rcare.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    @Override
    public SignsList list(Integer id, Integer num) {
        List<Sign> heart = signMapper.list(id, num, "heart");
        List<Sign> respire = signMapper.list(id, num, "respire");
        List<Sign> sbp = signMapper.list(id, num, "sbp");
        List<Sign> dbp = signMapper.list(id, num, "dbp");
        List<Sign> ecg = signMapper.list(id, 1024, "ecg");
        List<Status> statusList = signMapper.status(id);
        Status status = statusList.size() > 0 ? statusList.get(0) : null;
        SignsList signs = new SignsList(heart, respire, sbp, dbp, ecg, status);
        return signs;
    }

    @Override
    public boolean add(SignPost sign) {
        String[] validTypes = {"chest_pain", "exercise_angina", "heart_disease"};
        String[] validTypes2 = {"heart", "respire", "sbp", "dbp"};
        String type = sign.getType();

        if (Arrays.asList(validTypes).contains(type)) {
            signMapper.updateTmpTable(sign);
            return true;
        } else if (Arrays.asList(validTypes2).contains(type)) {
            signMapper.insert(sign);
            signMapper.updateTmpTable(sign);
            signMapper.insertTable(sign);
            return true;
        }
        return false;
    }

    @Override
    public List<SignTable> listTable(Integer id, Integer num) {
        return signMapper.listTable(id, num);
    }

    @Override
    public void add_ecg(SignPostEcg ecg) {
        signMapper.insert4ecg(ecg);
    }
}
