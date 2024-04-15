package cn.edu.hit.rcare.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 距离角度，插入格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistanceAnglePost {
    Integer member_id;
    Double distance;
    Double angle;
}
