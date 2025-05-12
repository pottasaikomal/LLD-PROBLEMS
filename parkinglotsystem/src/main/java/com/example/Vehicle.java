package com.example;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType type;
    public Vehicle(String vehicleNumber, VehicleType type){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public VehicleType getType() {
        return type;
    }
    public void setType(VehicleType type) {
        this.type = type;
    }
    
}
