package com.fawry.bookstore.models.Books;

public class PurchasableBook extends Book {
    private double price;

    public PurchasableBook(String ISBN, String title, int year, double price){
        super(ISBN, title, year);
        setPrice(price);
    }

    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        if(price >= 0){
            this.price = price;
        } else {
            throw new IllegalArgumentException("Invalid Price");
        }
    }
}
