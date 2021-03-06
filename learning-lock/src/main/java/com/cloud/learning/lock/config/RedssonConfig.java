package com.cloud.learning.lock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @ClassName: RedssonConfig
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 16:59
 * @Version: 1.0
 */
@Configuration
public class RedssonConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private String port;
    @Value("${redis.password}")
    private String password;

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
        return Redisson.create(config);
    }
}
