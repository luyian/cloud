package com.it.cloud.service;

import com.it.cloud.common.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author admin
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") // 8001的微服务名称
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    JsonResult getPaymentById(@PathVariable("id") Long id);
}
