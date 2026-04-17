package com.parkinglot.parking;

import java.util.List;
import java.util.ArrayList;
import com.parkinglot.enums.VehicleType;

public class Floor {
    private int floorNumber;
    private List<ParkingSpace> spaces;

    public Floor(int floorNumber, int numSpaces) {
        this.floorNumber = floorNumber;
        this.spaces = new ArrayList<>();
        // For simplicity, assume equal spaces for each type, but in reality, distribute
        int spacesPerType = numSpaces / 3;
        for (int i = 0; i < spacesPerType; i++) {
            spaces.add(new ParkingSpace(i + 1, floorNumber, VehicleType.TWO_WHEELER));
            spaces.add(new ParkingSpace(spacesPerType + i + 1, floorNumber, VehicleType.FOUR_WHEELER));
            spaces.add(new ParkingSpace(2 * spacesPerType + i + 1, floorNumber, VehicleType.HEAVY_VEHICLE));
        }
    }

    public ParkingSpace findAvailableSpace(VehicleType type) {
        for (ParkingSpace space : spaces) {
            if (!space.isOccupied() && space.getType() == type) {
                return space;
            }
        }
        return null;
    }

    public List<ParkingSpace> getSpaces() {
        return spaces;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}