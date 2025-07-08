package com.fawry.bookstore.models;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import com.fawry.bookstore.models.Books.Book;
import com.fawry.bookstore.models.Books.Types.*;

public class Inventory {
    private LinkedList<Book> books;

    public Inventory() {
        books = new LinkedList<>();
    }

    public void addPaperBook(String ISBN, String Title, int year, double price, int quantity) {
        books.add(new PaperBook(ISBN, Title, year, price, quantity));
    }

    public void addEBook(String ISBN, String Title, int year, double price, String filetype){
        books.add(new EBook(ISBN, Title, year, price, filetype));
    }
    
    public void addDemoBook(String ISBN, String Title, int year){
        books.add(new DemoBook(ISBN, Title, year));
    }

    public void removeBooksBefore(int year){
        books.removeIf(book -> book.getYear() < year);
    }

    public void printInventory(){
        int i = 0;
        for(Book book : books){
            System.out.println(String.format("%d. [%s] %s, %d", ++i, book.getISBN(), book.getTitle(), book.getYear()));
        }
    }

    public Book findBook(String ISBN){
        for(Book book : books){
            if (book.getISBN().equals(ISBN)){
                return book;
            }
        }
        throw new NoSuchElementException("Book does not exist in the inventory.");
    }
}
