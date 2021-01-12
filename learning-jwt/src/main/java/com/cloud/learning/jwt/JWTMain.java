package com.cloud.learning.jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: JWTMain
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 11:14
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.cloud.learning.jwt.dal")
public class JWTMain {
    public static void main(String[] args) {
        SpringApplication.run(JWTMain.class,args);
    }
}
