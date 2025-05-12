package com.example;

public class ParkingSpot {
    private String id;
    private VehicleType spotType;
    private boolean isOccupied;
    public ParkingSpot(String id, VehicleType type){
        this.id = id;
        this.spotType = type;
        isOccupied = false;
    }
    public void assign(){
        isOccupied = true;
    }
    public void unAssign(){
        isOccupied = false;
    }
    public boolean isFree(){
        return !isOccupied;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public VehicleType getSpotType() {
        return spotType;
    }
    public void setSpotType(VehicleType spotType) {
        this.spotType = spotType;
    }

}
