package com.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot spot;
    public Ticket(Vehicle vehicle, ParkingSpot spot){
        this.vehicle = vehicle;
        this.spot = spot;
        this.id = UUID.randomUUID().toString();
        this.entryTime = LocalDateTime.now();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }
    public ParkingSpot getSpot() {
        return spot;
    }
    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }
    
}
