package com.example;

public class Edge {
    private User from;
    private User to;
    private double amount;
    public Edge(User to,User from, double amount){
        this.to = to;
        this.from = from;
        this.amount = amount;
    }
    public User getFrom() {
        return from;
    }
    public void setFrom(User from) {
        this.from = from;
    }
    public User getTo() {
        return to;
    }
    public void setTo(User to) {
        this.to = to;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
