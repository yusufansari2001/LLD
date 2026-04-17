package com.vehiclerental.service;

import com.vehiclerental.model.*;
import com.vehiclerental.enums.*;
import java.time.LocalDateTime;
import java.util.*;

public class VehicleRentalSystem {
    private static VehicleRentalSystem instance;
    private List<Store> stores;
    private List<User> users;
    private List<Reservation> reservations;
    private List<Bill> bills;
    private List<Payment> payments;

    private VehicleRentalSystem() {
        stores = new ArrayList<>();
        users = new ArrayList<>();
        reservations = new ArrayList<>();
        bills = new ArrayList<>();
        payments = new ArrayList<>();
    }

    public static VehicleRentalSystem getInstance() {
        if (instance == null) {
            instance = new VehicleRentalSystem();
        }
        return instance;
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Reservation makeReservation(User user, VehicleType type, LocalDateTime start, LocalDateTime end, ReservationType resType, Store store) {
        Vehicle vehicle = store.getInventory().getAvailableVehicle(type);
        if (vehicle == null) {
            return null;
        }
        String resId = "RES" + reservations.size();
        Reservation res = new Reservation(resId, user, vehicle, start, end, resType, store);
        reservations.add(res);
        vehicle.setStatus(VehicleStatus.RENTED);
        return res;
    }

    public Bill generateBill(Reservation res) {
        long hours = java.time.Duration.between(res.getStartTime(), res.getEndTime()).toHours();
        double rate = res.getType() == ReservationType.HOURLY ? 10 : 50;
        double amount = hours * rate;
        String billId = "BILL" + bills.size();
        Bill bill = new Bill(billId, res, amount);
        bills.add(bill);
        return bill;
    }

    public Payment makePayment(Bill bill, PaymentMode mode) {
        String payId = "PAY" + payments.size();
        Payment payment = new Payment(payId, bill, mode, bill.getAmount());
        payments.add(payment);
        bill.setStatus(BillStatus.PAID);
        return payment;
    }

    public void returnVehicle(Reservation res) {
        res.setStatus(ReservationStatus.COMPLETED);
        res.getVehicle().setStatus(VehicleStatus.AVAILABLE);
    }

    public List<Store> getStores() { return stores; }
    public List<User> getUsers() { return users; }
}