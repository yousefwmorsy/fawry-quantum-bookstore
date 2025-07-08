package com.fawry.bookstore.models;

import java.util.NoSuchElementException;

import com.fawry.bookstore.models.Books.Book;
import com.fawry.bookstore.models.Books.Finite;
import com.fawry.bookstore.models.Books.Mailable;
import com.fawry.bookstore.models.Books.PurchasableBook;
import com.fawry.bookstore.models.Books.Shippable;
import com.fawry.bookstore.services.MailService;
import com.fawry.bookstore.services.ShippingService;

public class Shop {
    private Inventory inventory;
    private MailService mailService;
    private ShippingService shippingService;

    public Shop() {
        inventory = new Inventory();
        mailService = new MailService();
        shippingService = new ShippingService();
    }

    public void addBookToInventory(String ISBN, String title, int year, double price, int quantity) {
        inventory.addPaperBook(ISBN, title, year, price, quantity);
    }

    public void addBookToInventory(String ISBN, String title, int year, double price, String filetype) {
        inventory.addEBook(ISBN, title, year, price, filetype);
    }

    public void addBookToInventory(String ISBN, String title, int year) {
        inventory.addDemoBook(ISBN, title, year);
    }

    public void removeBooksBefore(int year) {
        inventory.removeBooksBefore(year);
    }

    public void printInventory(){
        inventory.printInventory();
    }

    public void buyBook(String ISBN, int quantity, String address, String email) {
        Book book;
        try{
            book = inventory.findBook(ISBN); 
        } catch (NoSuchElementException e) {
            System.out.println("[Error] " + e.getMessage());
            return;
        }
        if(book instanceof Finite){
            try{
                Finite finitebook = (Finite)book;
                finitebook.decreaseQuantity(quantity);
            } catch(IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage());
                return;
            }
        }
        if(book instanceof Shippable){
            shippingService.ship(book, quantity, address);
        }
        if(book instanceof Mailable){
            mailService.mail(book, email);
        }
        if(book instanceof PurchasableBook){
            System.out.println(String.format("[Successful Purchase] %dx %s at a price of %.2f", quantity, book.getTitle(), quantity * ((PurchasableBook)book).getPrice()));
        } else {
            System.out.println("[Error] Book is not purchasable");
        }
    }



}
