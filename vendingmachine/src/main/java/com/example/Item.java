package com.example;

public class Item {
    private String name;
    private String id;
    private int price;
    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name: " + name + " price: " + price;
    }
}
