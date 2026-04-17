package com.parkinglot.payment;

import com.parkinglot.enums.PaymentMode;

public class UPIPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        // Simulate UPI payment
        System.out.println("Processing UPI payment of $" + amount);
        return true;
    }

    @Override
    public PaymentMode getPaymentMode() {
        return PaymentMode.UPI;
    }
}