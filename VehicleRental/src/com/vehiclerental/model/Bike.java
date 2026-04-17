package com.vehiclerental.model;

import com.vehiclerental.enums.VehicleType;

public class Bike extends Vehicle {
    private String model;

    public Bike(String id, String model) {
        super(id, VehicleType.BIKE);
        this.model = model;
    }

    public String getModel() { return model; }
}