package com.cloud.learning.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: LockMain
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 16:59
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.cloud.learning.lock.dal.mapper")
public class LockMain {
    public static void main(String[] args) {
        SpringApplication.run(LockMain.class,args);
    }
}
