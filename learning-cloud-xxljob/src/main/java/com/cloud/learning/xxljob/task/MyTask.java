package com.cloud.learning.xxljob.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyTask
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/19 17:22
 * @Version: 1.0
 */
@Component
public class MyTask {

    /**
     * @XxlJob 中 value 值唯一即可
     * @param param
     * @return
     */
    @XxlJob("firstTask")
    public ReturnT<String> firstTask(String param) {

        XxlJobLogger.log("start firstTask param = {}", param);

        // 业务代码，此处作为演示只打印 hello xxl-job
        System.out.println("hello xxl-job");

        XxlJobLogger.log("end firstTask");

        return ReturnT.SUCCESS;

    }
}

