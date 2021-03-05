package com.it.cloud.service.impl;

import com.it.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author admin
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentOk() {
        return "thats ok";
    }

    @Override
    public String paymentError() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "something wrong";
    }
}
