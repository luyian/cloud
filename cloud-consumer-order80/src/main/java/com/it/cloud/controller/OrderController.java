package com.it.cloud.controller;

import com.it.cloud.common.JsonResult;
import com.it.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("unchecked")
    @GetMapping("/payment/create")
    public JsonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",
                payment, JsonResult.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/payment/get/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, JsonResult.class);
    }
}
