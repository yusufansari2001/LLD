package com.vehiclerental.model;

import com.vehiclerental.inventory.VehicleInventory;

public class Store {
    private String id;
    private Location location;
    private VehicleInventory inventory;

    public Store(String id, Location location) {
        this.id = id;
        this.location = location;
        this.inventory = new VehicleInventory();
    }

    public String getId() { return id; }
    public Location getLocation() { return location; }
    public VehicleInventory getInventory() { return inventory; }
}