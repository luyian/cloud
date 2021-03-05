package com.it.cloud.controller;

import com.it.cloud.common.JsonResult;
import com.it.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/{id}")
    public JsonResult getPaymentById(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
