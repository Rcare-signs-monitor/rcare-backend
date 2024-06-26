package cn.edu.hit.rcare.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 距离角度，查询返回格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistanceAngle {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime time;
    Double distance;
    Double angle;
}
