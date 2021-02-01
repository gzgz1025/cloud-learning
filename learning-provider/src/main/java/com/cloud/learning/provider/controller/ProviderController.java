package com.cloud.learning.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ProviderController
 * @Description:
 * 通过访问gateway网关/provide/sayHello/{name}（"pattern": "/provide/**"）,跳转至nacos-provider服务（"uri": "lb://nacos-provider"）
 * @Author: pzl
 * @CreateDate: 2021/2/1 15:09
 * @Version: 1.0
 */
@RestController
@RequestMapping("/provide/")
@Slf4j
public class ProviderController {

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        log.info("I'm calling nacos-provider service by dynamic gateway...");
        return name + " Hi~, I'm from nacos-provider";
    }
}
