package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.*;
import cn.edu.hit.rcare.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SignController {

    @Autowired
    private SignService signService;

    @GetMapping("/signs/{id}")
    public Result list(@PathVariable Integer id, Integer num, @RequestParam(defaultValue = "false") Boolean table){
        if (table){
            log.info("查询成员 {} 的全部体征，表格形式，数量限制{} ", id, num);
            List<SignTable> signsTable = signService.listTable(id, num);
            return Result.success(signsTable);
        }else {
            log.info("查询成员 {} 的全部体征，数组形式，数量限制{} ", id, num);
            SignsList signs = signService.list(id, num);
            return Result.success(signs);
        }
    }


    /**
     * @param sign
     * {
     *     "member_id": 成员id
     *     "type": ['heart', 'respire', 'sbp', 'dbp', 'ecg',
     *              'chest_pain', 'exercise_angina', 'heart_disease']
     * }
     * @return
     */
    @PostMapping("/signs")
    public Result add(@RequestBody SignPost sign){
        log.info("新建体征记录 {}", sign);
        boolean res = signService.add(sign);
        if (res) return Result.success();
        else return Result.error("字段取值错误");
    }

    @PostMapping("/ecg")
    public Result addEcg(@RequestBody SignPostEcg ecg){
        log.info("插入ECG数据");
        signService.add_ecg(ecg);
        return Result.success();
    }
}