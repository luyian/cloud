package com.it.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * openfeign提供了日志打印功能，从而让我们了解到调用细节。我们可以对日志级别进行配置，它提供了以下日志级别：
 *
 * NONE：不打印任何日志
 * BASIC：仅记录请求方法、URL、响应码和执行时间
 * HEADERS：除了BASIC的信息，还有请求和响应的头信息
 * FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文以及元数据
 *
 *在yml中开启openfeign的日志：
 * logging:
 *   level:
 *     # openfeign日志以什么级别监控哪个接口
 *     com.zhusl.springcloud.service.PaymentFeignService: debug
 *
 * @author admin
 */
@Configuration
public class FeignConfigure {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
