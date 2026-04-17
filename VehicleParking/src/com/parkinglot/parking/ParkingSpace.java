package com.parkinglot.parking;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.vehicle.Vehicle;

public class ParkingSpace {
    private int id;
    private int floorNumber;
    private VehicleType type;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpace(int id, int floorNumber, VehicleType type) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.type = type;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void vacate() {
        this.vehicle = null;
        this.occupied = false;
    }

    public VehicleType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}