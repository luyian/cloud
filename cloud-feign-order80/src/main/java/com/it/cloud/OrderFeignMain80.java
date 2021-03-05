package com.it.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 可以理解为就是基于Ribbon又做了一层封装。
 * 以前是Ribbon + RestTemplate，OpenFeign相当于封装了它们俩，我们使用时就直接用OpenFeign的注解即可。
 *
 * @author admin
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
