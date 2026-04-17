package com.vehiclerental.inventory;

import com.vehiclerental.model.Vehicle;
import com.vehiclerental.enums.VehicleType;
import com.vehiclerental.enums.VehicleStatus;
import java.util.*;

public class VehicleInventory {
    private Map<VehicleType, List<Vehicle>> inventory;

    public VehicleInventory() {
        inventory = new HashMap<>();
        for (VehicleType type : VehicleType.values()) {
            inventory.put(type, new ArrayList<>());
        }
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.get(vehicle.getType()).add(vehicle);
    }

    public List<Vehicle> getVehicles(VehicleType type) {
        return inventory.get(type);
    }

    public Vehicle getAvailableVehicle(VehicleType type) {
        for (Vehicle v : inventory.get(type)) {
            if (v.getStatus() == VehicleStatus.AVAILABLE) {
                return v;
            }
        }
        return null;
    }
}