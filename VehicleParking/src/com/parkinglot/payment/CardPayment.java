package com.parkinglot.payment;

import com.parkinglot.enums.PaymentMode;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        // Simulate card payment
        System.out.println("Processing card payment of $" + amount);
        return true;
    }

    @Override
    public PaymentMode getPaymentMode() {
        return PaymentMode.CARD;
    }
}