package com.cloud.learning.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GatewayConfig
 * @Description: 从Nacos配置中心中加载动态路由的相关配置，就需要读取Nacos的命名空间namespace，通过dataId获取配置
 * @Author: pzl
 * @CreateDate: 2021/2/1 14:32
 * @Version: 1.0
 */
@Configuration
public class GatewayConfig {
    public static final long DEFAULT_TIMEOUT = 30000;

    public static String NACOS_SERVER_ADDR;

    public static String NACOS_NAMESPACE;

    public static String NACOS_ROUTE_DATA_ID;

    public static String NACOS_ROUTE_GROUP;

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    public void setNacosServerAddr(String nacosServerAddr){
        NACOS_SERVER_ADDR = nacosServerAddr;
    }

    @Value("${spring.cloud.nacos.discovery.namespace}")
    public void setNacosNamespace(String nacosNamespace){
        NACOS_NAMESPACE = nacosNamespace;
    }

    @Value("${nacos.gateway.route.config.data-id}")
    public void setNacosRouteDataId(String nacosRouteDataId){
        NACOS_ROUTE_DATA_ID = nacosRouteDataId;
    }

    @Value("${nacos.gateway.route.config.group}")
    public void setNacosRouteGroup(String nacosRouteGroup){
        NACOS_ROUTE_GROUP = nacosRouteGroup;
    }

}
