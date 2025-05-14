package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Komal", "U1");
        User user2 = new User("Shishir", "U2");
        User user3 = new User("AZ", "U3");
        Splitwise app = new Splitwise();
        app.addUser(user3);
        app.addUser(user1);
        app.addUser(user2);
        Map<String, Double> mp = new HashMap<>();
        mp.put("Komal", 100.0);
        mp.put("AZ", 20.0);
        app.splitByAmount(user2, mp);
        app.netBalance("Komal");
        Map<String, Double> mp1 = new HashMap<>();
        mp1.put("Shishir", 55.5);
        mp1.put("AZ", 44.3);
        app.splitByPercentage(user1, mp1, 1000);
        app.netBalance("Komal");
    }
}