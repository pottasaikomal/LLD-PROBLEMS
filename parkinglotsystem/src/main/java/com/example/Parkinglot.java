package com.example;

import java.util.List;

public class Parkinglot {
    private List<ParkingSpot> spots;
    public Parkinglot(List<ParkingSpot> spots){
        this.spots = spots;
    }
    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot: spots){
            if(spot.getSpotType() == vehicle.getType() && spot.isFree()){
                spot.assign();
                Ticket ticket = new Ticket(vehicle, spot);
                return ticket;
            }
        }
        throw new RuntimeException("No free spots left");
    }
    public double exitVehicle(Ticket ticket){
        ticket.getSpot().unAssign();
        return Payment.calculateCost(ticket);
    }
}
