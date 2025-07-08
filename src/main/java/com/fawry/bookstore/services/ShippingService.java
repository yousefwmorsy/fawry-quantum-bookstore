package com.fawry.bookstore.services;

import com.fawry.bookstore.models.Books.Book;

public class ShippingService {
    public ShippingService() {

    }

    public void ship(Book book, int quantity, String address){
        System.out.println(String.format("[Successful Shipping Request] %dx %s to %s", quantity, book.getTitle(), address));
    }
}
