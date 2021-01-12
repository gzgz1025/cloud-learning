package com.cloud.learning.jwt.config;

import com.cloud.learning.jwt.interceptor.ValidateLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: InterceptorConfig
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/12 16:01
 * @Version: 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径，/**表示需要拦截所有请求
        String[]addPathPatterns={"/usr/**"};
        //不需要拦截的路径
        String [] excludePathPaterns={
                "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"
        };
        //注册一个登录拦截器
        registry.addInterceptor(new ValidateLoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPaterns);
        //注册一个权限拦截器  如果有多个拦截器 ，只需要添加以下一行代码
        //registry.addInterceptor(new LoginInterceptor())
        // .addPathPatterns(addPathPatterns)
        // .excludePathPatterns(excludePathPatterns);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
