package com.fawry.bookstore.models.Books.Types;

import com.fawry.bookstore.models.Books.Finite;
import com.fawry.bookstore.models.Books.PurchasableBook;
import com.fawry.bookstore.models.Books.Shippable;

public class PaperBook extends PurchasableBook implements Shippable, Finite {
    private int quantity;
    
    public PaperBook(String ISBN, String title, int year, double price, int quantity){
        super(ISBN, title, year, price);
        setQuantity(quantity);
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        if(quantity >= 0){
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity cannot be negative!");
        }
    }

    public void decreaseQuantity(int quantity){
        if(getQuantity() - quantity < 0){
            throw new IllegalArgumentException("Stock insufficient.");
        } else {
            this.quantity -= quantity;
        }
    }
}
