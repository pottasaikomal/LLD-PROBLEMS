package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
    private List<User> users;
    private Graph transactions;
    private Map<User, Map<User, Double>> edges;
    Splitwise(){
        transactions = new Graph();
        users = new ArrayList<>();
        edges = new HashMap<>();
    }
    public void addUser(User u){
        users.add(u);
        edges.put(u, new HashMap<>());
    }
    private User getUser(String name){
        for(User u: users){
            if(u.getName() == name) return u;
        }
        return null;
    }
    public void splitByAmount(User U1, Map<String, Double> mp){
        for(String name: mp.keySet()){
            User U2 = getUser(name);
            if(U2 == null){
                System.out.println("Invalid Entry!!");
                return;
            }
            transactions.addEdge(U1, U2, mp.get(name));
            edges.get(U1).put(U2, mp.get(name));
        }
    }
    public void splitByPercentage(User U1, Map<String, Double> mp, int amount){
        double total = 0.0;
        for(double value : mp.values()) total += value;
        double epsilon = 1e-6;
        if(total > 100 +  epsilon){
            System.out.println("Invalid Split Percentages!!");
            return;
        }
        for(String name: mp.keySet()){
            User U2 = getUser(name);
            if(U2 == null){
                System.out.println("Invalid Entry!!");
                return;
            }
            transactions.addEdge(U1, U2, mp.get(name)*amount/100);
        }
    }
    public void netBalance(String name){
        User U1 = getUser(name);
        double netBalance = transactions.netBalance(U1);
        System.out.println("User " + U1.getName() + "has a net balance of " + netBalance);
    }
    public void netTransfer(String n1, String n2){
        User U1 = getUser(n1);
        User U2 = getUser(n2);
        double netTransfer = transactions.netTransfer(U1, U2);
        if(netTransfer < 0.0) {
            System.out.println("User " + U2.getName() + "has to pay a total amount of: " + netTransfer + "to User " + U1.getName());
        }
        else if(netTransfer > 0.0){
            System.out.println("User " + U1.getName() + "has to pay a total amount of: " + netTransfer + "to User " + U2.getName());
        }
        else{
            System.out.println("User " + U1.getName() + "and User " + U2.getName() + "are settled!!");
        }
    }
}
