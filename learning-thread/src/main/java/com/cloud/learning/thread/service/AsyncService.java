package com.cloud.learning.thread.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AsyncService
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 16:39
 * @Version: 1.0
 */
@Service
@Slf4j
public class AsyncService {
    //asyncServiceExecutor为ExecutorConfig中的bean
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start AsyncService");
        try {
            //逻辑操作
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end AsyncService");
    }
}

