package com.it.cloud.controller;

import com.it.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/ok")
    public String ok() {
        return paymentService.paymentOk() + "\r\n" + port;
    }

    @GetMapping("/error")
    public String error() {
        return paymentService.paymentError() + "\r\n" + port;
    }
}
