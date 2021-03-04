package com.it.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    public String port;

    @GetMapping("/zk")
    public String getPort() {
        return "该服务的端口号为：" + port;
    }
}
