package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignsList {
    List<Sign> heart;
    List<Sign> respire;
    List<Sign> sbp;
    List<Sign> dbp;
    List<Sign> temper;
    List<Sign> ecg;
    Status status;
}
