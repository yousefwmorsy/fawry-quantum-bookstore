package com.fawry.bookstore;

import java.util.Scanner;

import com.fawry.bookstore.models.Shop;

public class Main {
    private static Shop shop = new Shop();
    private static Scanner scanner = new Scanner(System.in);

    public static void addMenu(){
        System.out.println("----- Add Book Menu -----");
        String[] availableTypes = {"Paper Book", "EBook", "Demo Book"};
        System.out.println("Available Types: ");
        int i = 0;
        for(String type : availableTypes){
            System.out.println("[" + (++i) + "] " + type );
        }
        System.out.print("Please choose a type: ");
        int type = scanner.nextInt();
        while(type < 1 || type > availableTypes.length){
            System.out.print("[Out of Bounds] Please choose a type: ");
            type = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Publish Year: ");
        int year = scanner.nextInt();
            
        double price = 0;
        if(type == 1 || type == 2){
            System.out.print("Enter Price: ");
            price = scanner.nextDouble();
            scanner.nextLine();
        }
        int quantity = 0;
        if(type == 1) {
            System.out.print("Enter Quantity: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
        }
        String filetype = "";
        if(type == 2){
            System.out.print("Enter FileType: ");
            filetype = scanner.nextLine();
        }

        try{
            switch (type) {
                case 1:
                    shop.addBookToInventory(ISBN, title, year, price, quantity);
                    break;
                case 2:
                    shop.addBookToInventory(ISBN, title, year, price, filetype);
                    break;
                case 3:
                    shop.addBookToInventory(ISBN, title, year);
                    break;
                default:
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] " + e.getMessage());
        }
        System.out.println("----- Updated Books List -----");
        shop.printInventory();
    }

    public static void deleteMenu(){
        System.out.println("----- Delete Books Menu -----");
        System.out.println("Available books:");
        shop.printInventory();

        System.out.print("Enter a year to delete books published before it: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        shop.removeBooksBefore(year);

        System.out.println("----- Updated Books List -----");
        shop.printInventory();
    }

    public static void buyMenu(){
        System.out.println("----- Buy Books Menu -----");
        
        System.out.println("Available books:");
        shop.printInventory();

        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        shop.buyBook(ISBN, quantity, address, email);
    }

    public static void main(String[] args) {
        while(true){
            System.out.println("======= Shop Options =======");
            System.out.println("1. Add Book to Inventory");
            System.out.println("2. Remove Outdated Books");
            System.out.println("3. Purchase a book");
            System.out.println("[Exit by choosing any other option]");
            System.out.println("============================");
            System.out.print("Selection: ");
            int selection = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (selection) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    deleteMenu();
                    break;
                case 3:
                    buyMenu();
                    break;
                default:
                    System.out.println("Exiting...");
                    return;
            }
            System.out.println();
        }
    }
}