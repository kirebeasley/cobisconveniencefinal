package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cobisstore> inventory = new ArrayList<Cobisstore>();
        ArrayList<Customer> order = new ArrayList<Customer>();
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();

        Cobisstore cs = new Cobisstore();
        cs.setProduct("Red-Hot Spicy Doritos");
        cs.setPrice(2.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Cool Ranch Doritos");
        cs.setPrice(2.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Coke");
        cs.setPrice(0.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Diet Coke");
        cs.setPrice(0.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Pepsi");
        cs.setPrice(0.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Five Hour Energy");
        cs.setPrice(3.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Sunflower Seeds");
        cs.setPrice(0.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Peanuts");
        cs.setPrice(0.99);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Mac Book Charger");
        cs.setPrice(120.00);
        inventory.add(cs);
        cs = new Cobisstore();
        cs.setProduct("Dell Charger");
        cs.setPrice(50.00);
        inventory.add(cs);

        Scanner input = new Scanner(System.in);
        String response = "";
        String product = " ";
        int index = -1;

        do {
            System.out.println("Welcome to Cobis Convenience! What would you like to do?" + " " +
                    "Type 'a' for add customer. Type 'c' for close store. ");
            response = input.nextLine();
            if (response.equals("a")) {
                System.out.print("Name:");
                String customername = input.nextLine();
                Customer co = new Customer();
                co.setName(customername);

                Receipt newreceipt = new Receipt();
                newreceipt.setCustname(customername);
                receipts.add(newreceipt);
                do {
                    System.out.println("Thank you. Which product would you like to purchase? If you are finished shopping please type 'finished'.");
                    product = input.nextLine();
                    for (int i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).getProduct().equals(product)) {
                            index = i;
                            String cppd = inventory.get(index).getProduct();
                            Double cppr = inventory.get(index).getPrice();
                            co = new Customer();
                            co.setName(customername);
                            co.setProdpurch(cppd);
                            co.setProdprice(cppr);
                            order.add(co);

                            inventory.get(i).setInventory(inventory.get(i).getInventory() + 1);

                            newreceipt.setCost(newreceipt.getCost() + inventory.get(index).getPrice());
                            newreceipt.addCustomerorders(co);
                        }
                    }
                } while (!product.equals("finished"));
            }
                } while (!response.equals("c"));


        System.out.println("Closing Receipts:");

        for (int i = 0; i < receipts.size(); i++) {
            System.out.println(receipts.get(i).getCustname());
            for (int j = 0; j < receipts.get(i).getCustomerorders().size(); j++) {
                System.out.println(receipts.get(i).getCustomerorders().get(j).getProdpurch());
            }
            System.out.println(receipts.get(i).getCost());
            System.out.println("-------------");
        }
        System.out.println("Inventory Sold");
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getInventory() > 0) {
                System.out.println("    " + inventory.get(i).getProduct() + ":" + "(" + inventory.get(i).getInventory() + ")");
            }
        }
        double totalcost = 0.0;
        for (int i = 0; i < order.size(); i++) {
            double item = order.get(i).getProdprice();
            totalcost += item;
        }
               System.out.println(" ");
        System.out.println("Grand Total" + ": " + totalcost);
        }
    }








