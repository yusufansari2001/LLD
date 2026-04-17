package com.vehiclerental.model;

import com.vehiclerental.enums.ReservationStatus;
import com.vehiclerental.enums.ReservationType;
import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ReservationStatus status;
    private ReservationType type;
    private Store store;

    public Reservation(String id, User user, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime, ReservationType type, Store store) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = ReservationStatus.PENDING;
        this.type = type;
        this.store = store;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Vehicle getVehicle() { return vehicle; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public ReservationStatus getStatus() { return status; }
    public void setStatus(ReservationStatus status) { this.status = status; }
    public ReservationType getType() { return type; }
    public Store getStore() { return store; }
}