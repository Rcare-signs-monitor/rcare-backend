package cn.edu.hit.rcare.service;


import cn.edu.hit.rcare.pojo.Calling;

public interface PatientServer {
    void setCalling(Calling calling);

    Integer getCalling(Integer id);
}
