package com.fawry.bookstore.services;

import com.fawry.bookstore.models.Books.Book;

public class MailService {
    public MailService(){

    }

    public void mail(Book book, String email){
        System.out.println(String.format("[Successful Mail Request] %s to %s", book.getTitle(), email));
    }
}
