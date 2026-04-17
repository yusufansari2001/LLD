package com.vehiclerental.model;

import com.vehiclerental.enums.BillStatus;

public class Bill {
    private String id;
    private Reservation reservation;
    private double amount;
    private BillStatus status;

    public Bill(String id, Reservation reservation, double amount) {
        this.id = id;
        this.reservation = reservation;
        this.amount = amount;
        this.status = BillStatus.UNPAID;
    }

    public String getId() { return id; }
    public Reservation getReservation() { return reservation; }
    public double getAmount() { return amount; }
    public BillStatus getStatus() { return status; }
    public void setStatus(BillStatus status) { this.status = status; }
}