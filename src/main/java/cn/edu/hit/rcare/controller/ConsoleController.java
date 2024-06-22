package cn.edu.hit.rcare.controller;

import cn.edu.hit.rcare.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
@RestController
public class ConsoleController {

    /**
     * 参数初始化
     * @return
     */
    @GetMapping("/init")
    public Result init(){

        String command  = "sudo sh /home/ubuntu/runInit.sh";

        return runCommand(command);
    }

    /**
     * 采集数据
     * @return
     */
    @GetMapping("/collect")
    public Result collect() {

        String command = "sudo sh /home/ubuntu/runCollect.sh";

        return runCommand(command);
    }

    /**
     * 停止运行
     * @return
     */
    @GetMapping("/stop")
    public Result stop() {

        String command = "sudo sh /home/ubuntu/runSignal.sh";

        return runCommand(command);
    }

    @GetMapping("/command1")
    public Result command1() {

        String command = "sudo sh /home/ubuntu/command1.sh";

        return runCommand(command);
    }
    @GetMapping("/command2")
    public Result command2() {

        String command = "sudo sh /home/ubuntu/command2.sh";

        return runCommand(command);
    }
    @GetMapping("/command3")
    public Result command3() {

        String command = "sudo sh /home/ubuntu/command3.sh";

        return runCommand(command);
    }
    @GetMapping("/command4")
    public Result command4() {

        String command = "sudo sh /home/ubuntu/command4.sh";

        return runCommand(command);
    }
    @GetMapping("/command5")
    public Result command5() {

        String command = "sudo sh /home/ubuntu/runSignal.sh";

        return runCommand(command);
    }
    @GetMapping("/command6")
    public Result command6() {

        String command = "sudo sh /home/ubuntu/command6.sh";

        return runCommand(command);
    }

    @GetMapping("/command7")
    public Result command7() {

        String command = "sudo sh /home/ubuntu/command7.sh";

        return runCommand(command);
    }

    @GetMapping("/command8")
    public Result command8() {

        String command = "sudo sh /home/ubuntu/command8.sh";

        return runCommand(command);
    }

    private Result runCommand(String command) {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);

            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));

            String s;
            if ((s = stdError.readLine()) != null) {
                log.info(s);
            }

            return Result.success();
        } catch (Exception e) {
            return Result.error("failed to run command " + command+"\n" + e.getStackTrace());
        }
    }
}
