package com.cloud.learning.thread.controller;

import com.cloud.learning.thread.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AsyncController
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 16:42
 * @Version: 1.0
 */
@RestController
@RequestMapping("/thread/")
@Slf4j
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/start")
    public String submit() {
        log.info("start submit");
        //调用service
        this.asyncService.executeAsync();
        //调用结束 打印日志
        log.info("end submit");

        return "success";
    }
}
