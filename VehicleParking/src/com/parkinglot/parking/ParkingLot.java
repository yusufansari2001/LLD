package com.parkinglot.parking;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.gate.GateManager;
import com.parkinglot.gate.EntryGate;
import com.parkinglot.gate.ExitGate;
import java.util.List;
import java.util.ArrayList;

public class ParkingLot {
    private String name;
    private List<Floor> floors;
    private GateManager gateManager;

    public ParkingLot(String name, int numFloors, int spacesPerFloor) {
        this.name = name;
        this.floors = new ArrayList<>();
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i, spacesPerFloor));
        }
        this.gateManager = new GateManager();
        // Add some gates
        for (int i = 1; i <= 2; i++) {
            gateManager.addEntryGate(new EntryGate(i, this));
            gateManager.addExitGate(new ExitGate(i));
        }
    }

    public ParkingSpace findAvailableSpace(VehicleType type) {
        for (Floor floor : floors) {
            ParkingSpace space = floor.findAvailableSpace(type);
            if (space != null) {
                return space;
            }
        }
        return null;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public GateManager getGateManager() {
        return gateManager;
    }
}