package cn.edu.hit.rcare.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sign {
    Integer id;
    Double heartRate;
    Double respiratoryRate;
    Double systolicPressure;
    Double diastolicPressure;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime detectionTime;
    Integer memberId;
}
