package com.example;

import java.util.*;

public class Main {
    public static void main(String[] args){
    List<ParkingSpot> spots = new ArrayList<>();
    spots.add(new ParkingSpot("C1", VehicleType.CAR));
    spots.add(new ParkingSpot("B1", VehicleType.BIKE));
    // spots.add(new ParkingSpot("O1", VehicleType.OTHERS));
    spots.add(new ParkingSpot("C2", VehicleType.CAR));
    spots.add(new ParkingSpot("B2", VehicleType.BIKE));

    Parkinglot lot = new Parkinglot(spots);
    Vehicle car1 = new Vehicle("AP 31 BZ 3000", VehicleType.CAR);
    Vehicle bike1 = new Vehicle("AP 32 NX 1000", VehicleType.BIKE);
    Vehicle other1 = new Vehicle("MH 20 AB 2003", VehicleType.OTHERS);

    Ticket car1Ticket = lot.parkVehicle(car1);
    System.out.println("Parking ticket id of " + car1.getVehicleNumber() + ": " + car1Ticket.getId());
    Ticket bike1Ticket = lot.parkVehicle(bike1);
    System.out.println("Parking ticket id of " + bike1.getVehicleNumber() + ": " + bike1Ticket.getId());
    Ticket otherTicket = lot.parkVehicle(other1);
    System.out.println("Parking ticket id of " + other1.getVehicleNumber() + ": " + otherTicket.getId());
    
    try{
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    double fee1  = lot.exitVehicle(car1Ticket);
    System.out.println("Fare for parking of vehicle with ticket id "+ car1Ticket.getId() + "is : " + fee1);

    try{
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    double fee2 = lot.exitVehicle(otherTicket);
    System.out.println("Fare for parking of vehicle with ticket id "+ otherTicket.getId() + "is : " + fee2);

    try{
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    double fee3 = lot.exitVehicle(bike1Ticket);
    System.out.println("Fare for parking of vehicle with ticket id "+ bike1Ticket.getId() + "is : " + fee3);

    }
}