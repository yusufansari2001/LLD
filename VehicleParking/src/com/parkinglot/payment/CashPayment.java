package com.parkinglot.payment;

import com.parkinglot.enums.PaymentMode;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        // Simulate cash payment
        System.out.println("Processing cash payment of $" + amount);
        return true;
    }

    @Override
    public PaymentMode getPaymentMode() {
        return PaymentMode.CASH;
    }
}