package cn.edu.hit.rcare.service;

import cn.edu.hit.rcare.pojo.SignPost;
import cn.edu.hit.rcare.pojo.SignPostEcg;
import cn.edu.hit.rcare.pojo.SignTable;
import cn.edu.hit.rcare.pojo.SignsList;

import java.util.List;

public interface SignService {
    SignsList list(Integer id, Integer num);

    boolean add(SignPost sign);

    List<SignTable> listTable(Integer id, Integer num);

    void add_ecg(SignPostEcg ecg);
}
