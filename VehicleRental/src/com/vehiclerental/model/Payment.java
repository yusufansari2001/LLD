package com.vehiclerental.model;

import com.vehiclerental.enums.PaymentMode;

public class Payment {
    private String id;
    private Bill bill;
    private PaymentMode mode;
    private double amount;

    public Payment(String id, Bill bill, PaymentMode mode, double amount) {
        this.id = id;
        this.bill = bill;
        this.mode = mode;
        this.amount = amount;
    }

    public String getId() { return id; }
    public Bill getBill() { return bill; }
    public PaymentMode getMode() { return mode; }
    public double getAmount() { return amount; }
}