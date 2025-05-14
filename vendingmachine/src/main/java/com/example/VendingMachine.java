package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {
    List<Item> items;
    HashMap<String, Integer> stockquantity;

    public VendingMachine() {
        items = new ArrayList<>();
        stockquantity = new HashMap<>();
    }

    public void displayStock() {
        System.out.println("Please find the stock details: ");
        System.out.printf("%-20s %-10s %-10s%n", "Name", "Quantity", "Price");
        System.out.println("-----------------------------------------------");

        for (Item item : items) {
            String name = item.getName();
            int price = item.getPrice();
            int quantity = stockquantity.get(name.toLowerCase());
            System.out.printf("%-20s %-10d %-10d%n", name, quantity, price);
        }

    }

    public void addItem(Item item, int quantity) {
        items.add(item);
        stockquantity.put(item.getName().toLowerCase(), quantity);
    }

    public int getPrice(String name) {
        name = name.toLowerCase();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item.getPrice();
            }
        }
        return -1;
    }

    public boolean dispenseItem(String name, int quantity, int cash) {
        name = name.toLowerCase();
        int available = stockquantity.getOrDefault(name, 0);
        if (available < quantity) {
            System.out.println("Out of Stock!!");
            return false;
        }
        int price = getPrice(name);

        // need to write in payment class
        if (price == -1) {
            System.out.println("Mentioned item doesnot exist!!");
            return false;
        }
        if (cash < quantity * price) {
            System.out.println("Insuficient amount!!");
            return false;
        }
        int rem = cash - quantity * price;
        stockquantity.put(name, available-quantity);
        System.out.println("Please collect remaining Amount:" + rem);
        return true;
    }
}
