package com.it.cloud.controller;

import com.it.cloud.common.JsonResult;
import com.it.cloud.entities.Payment;
import com.it.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public JsonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return JsonResult.OK;
        }
        return new JsonResult(400, "fail");
    }

    @GetMapping("/{id}")
    public JsonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new JsonResult(payment);
        }
        return new JsonResult(400, "fail");
    }
}
