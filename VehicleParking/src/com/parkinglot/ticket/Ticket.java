package com.parkinglot.ticket;

import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.parking.ParkingSpace;
import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpace parkingSpace;
    private LocalDateTime entryTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpace parkingSpace) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpace = parkingSpace;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}