package com.parkinglot.payment;

import com.parkinglot.enums.PaymentMode;

public interface PaymentStrategy {
    boolean processPayment(double amount);
    PaymentMode getPaymentMode();
}