package com.parkinglot.payment;

import com.parkinglot.enums.PaymentMode;
import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private double amount;
    private PaymentMode mode;
    private LocalDateTime paymentTime;
    private boolean successful;

    public Payment(String paymentId, double amount, PaymentMode mode) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.mode = mode;
        this.paymentTime = LocalDateTime.now();
    }

    public boolean process(PaymentStrategy strategy) {
        this.successful = strategy.processPayment(amount);
        return successful;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public boolean isSuccessful() {
        return successful;
    }
}