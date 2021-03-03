package com.it.cloud.service;

import com.it.cloud.entities.Payment;

/**
 * @author admin
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
