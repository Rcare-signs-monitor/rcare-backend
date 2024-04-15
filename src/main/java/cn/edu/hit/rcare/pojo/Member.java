package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成员信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    Integer id;
    String room;
    String bed;
    String name;
    Short gender;
    Short age;
    String doctor;
    Integer day;
    String result;
    String allergy;
    String healing;
    String contact;
    String attention;
    String image;
    String openid;
}
