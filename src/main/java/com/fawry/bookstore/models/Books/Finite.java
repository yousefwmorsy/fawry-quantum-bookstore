package com.fawry.bookstore.models.Books;

public interface Finite {
    int getQuantity();
    void setQuantity(int quantity);
    void decreaseQuantity(int quantity);
}
