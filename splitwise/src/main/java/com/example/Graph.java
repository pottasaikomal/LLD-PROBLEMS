package com.example;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge> edges;
    public Graph(){
        edges = new ArrayList<>();
    }
    public void addEdge(User U1, User U2, double amount){
        Edge edge = new Edge(U1, U2, amount);
        edges.add(edge);
    }
    public double netBalance(User U1){
        double netBalance = 0;
        for(Edge e: edges){
            if(e.getFrom() == U1) netBalance -= e.getAmount();
            else if(e.getTo() == U1) netBalance += e.getAmount();
        }
        return netBalance;
    }
    public double netTransfer(User U1, User U2){
        double netTransfer = 0;
        for(Edge e: edges){
            if(e.getFrom() == U1 && e.getTo() == U2) netTransfer += e.getAmount();
            else if(e.getTo() == U1 && e.getFrom() == U1) netTransfer -= e.getAmount();
        }
        return netTransfer;
    }
}
