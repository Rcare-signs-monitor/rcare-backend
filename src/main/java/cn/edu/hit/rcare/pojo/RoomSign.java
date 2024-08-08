package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomSign {
    String room;
    String bed;
    Integer id;
    String name;
    Double heart;
    Double respire;
    Double sbp;
    Double dbp;
    Double temper;
}
