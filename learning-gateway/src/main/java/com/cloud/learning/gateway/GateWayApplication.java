package com.cloud.learning.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GateWayMain
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/2/1 11:20
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }
}
