package cn.edu.hit.rcare.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成员信息和对应体征列表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSign {
    Member info;
    SignsList signs;
}
