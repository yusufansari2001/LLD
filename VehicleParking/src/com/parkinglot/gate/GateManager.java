package com.parkinglot.gate;

import java.util.List;
import java.util.ArrayList;

public class GateManager {
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;

    public GateManager() {
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
    }

    public void addEntryGate(EntryGate gate) {
        entryGates.add(gate);
    }

    public void addExitGate(ExitGate gate) {
        exitGates.add(gate);
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }
}