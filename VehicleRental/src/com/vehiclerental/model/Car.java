package com.vehiclerental.model;

import com.vehiclerental.enums.VehicleType;

public class Car extends Vehicle {
    private String model;

    public Car(String id, String model) {
        super(id, VehicleType.CAR);
        this.model = model;
    }

    public String getModel() { return model; }
}