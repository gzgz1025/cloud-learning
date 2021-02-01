package com.cloud.learning.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConsumeController
 * @Description:
 * 通过访问gateway网关/consume/sayHello/{name}（"pattern": "/consume/**"）,跳转至nacos-consumer服务（"uri": "lb://nacos-consumer"）
 * @Author: pzl
 * @CreateDate: 2021/2/1 15:06
 * @Version: 1.0
 */
@RestController
@RequestMapping("/customer/")
@Slf4j
public class ConsumeController {

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        log.info("I'm calling nacos-consumer service by dynamic gateway...");
        return name + " Hi~, I'm from nacos-consumer";
    }

}
