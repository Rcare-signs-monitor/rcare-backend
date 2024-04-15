package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signs {
    Sign heart;
    Sign respire;
    Sign sbp;
    Sign dbp;
    Sign ecg;
}
