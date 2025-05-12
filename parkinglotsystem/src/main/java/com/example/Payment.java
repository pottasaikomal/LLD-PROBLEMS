package com.example;

import java.time.LocalDateTime;

public class Payment{
    public static double calculateCost(Ticket ticket){
        double hours = java.time.Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMillis();
        return Math.max(20, hours*2.5);
    }
}
