package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignPost {
    Integer member_id;
    String type;
    Double data;
}
