package com.parkinglot.gate;

import com.parkinglot.ticket.Ticket;
import com.parkinglot.payment.Payment;
import com.parkinglot.payment.PaymentStrategy;
import java.time.Duration;

public class ExitGate {
    private int gateId;

    public ExitGate(int gateId) {
        this.gateId = gateId;
    }

    public Payment calculateAndProcessPayment(Ticket ticket, PaymentStrategy strategy) {
        // Calculate duration in hours
        long hours = Duration.between(ticket.getEntryTime(), java.time.LocalDateTime.now()).toHours();
        if (hours == 0) hours = 1; // Minimum 1 hour
        double rate = getRate(ticket.getVehicle().getType());
        double amount = hours * rate;

        String paymentId = "P" + System.currentTimeMillis();
        Payment payment = new Payment(paymentId, amount, strategy.getPaymentMode());
        payment.process(strategy);

        // Vacate the space
        ticket.getParkingSpace().vacate();

        return payment;
    }

    private double getRate(com.parkinglot.enums.VehicleType type) {
        switch (type) {
            case TWO_WHEELER: return 10.0;
            case FOUR_WHEELER: return 20.0;
            case HEAVY_VEHICLE: return 50.0;
            default: return 0.0;
        }
    }
}