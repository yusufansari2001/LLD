package com.parkinglot.gate;

import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.parking.ParkingLot;
import com.parkinglot.ticket.Ticket;

public class EntryGate {
    private int gateId;
    private ParkingLot parkingLot;

    public EntryGate(int gateId, ParkingLot parkingLot) {
        this.gateId = gateId;
        this.parkingLot = parkingLot;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        // Allocate parking space close to entrance
        // For simplicity, find any available space of the type
        var space = parkingLot.findAvailableSpace(vehicle.getType());
        if (space != null) {
            space.occupy(vehicle);
            String ticketId = "T" + System.currentTimeMillis();
            return new Ticket(ticketId, vehicle, space);
        }
        return null; // No space available
    }
}