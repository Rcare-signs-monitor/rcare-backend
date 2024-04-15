package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 病房-病床-病患id姓名
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    String room;
    String bed;
    Integer id;
    String name;
}
