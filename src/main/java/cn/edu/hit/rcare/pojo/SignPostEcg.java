package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignPostEcg {
    Integer member_id;
    List<Double> data;
}
