package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Lays1", 25);
        Item item2 = new Item("Hide&Seek", 45);
        Item item3 = new Item("Bingo", 5);
        VendingMachine machine = new VendingMachine();
        machine.addItem(item1, 4);
        machine.addItem(item2, 5);
        machine.addItem(item3, 6);
        System.out.println("Press keys as mentioned below");
        System.out.println("Press 1 for display items.");
        System.out.println("Press 2 for details input.");
        System.out.println("Press 3 for exit.");
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number: ");
            int function = scanner.nextInt();
            scanner.nextLine();

            if (function == 1) {
                machine.displayStock();
            } else if (function == 2) {
                System.out.print("Select Item Name you want: ");
                String name = scanner.nextLine();

                System.out.print("Select the quantity required: ");
                int quantity = scanner.nextInt();

                System.out.print("Input the cash you have: ");
                int amount = scanner.nextInt();

                boolean res = machine.dispenseItem(name, quantity, amount);
                if (res){
                    System.out.println("Items has been dispensed. Please vist us again!!");
                    break;
                }
            } else if (function == 3) {
                break;
            } else {
                System.out.println("Please enter either 1/2/3 to proceed forward");
            }
        }

    }
}