package com.fawry.bookstore.models.Books;
public abstract class Book {
    private String ISBN;
    private String title;
    private int year;

    public Book(String ISBN, String title, int year){
        setISBN(ISBN);
        setTitle(title);
        setYear(year);    
    }
        
    public String getISBN(){
        return ISBN;
    }

    public String getTitle(){
        return title;
    }

    public int getYear(){
        return year;
    }


    public void setISBN(String ISBN){
        if(!ISBN.isEmpty()){
            this.ISBN = ISBN;
        } else {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
    }

    public void setTitle(String title){
        if(!title.isEmpty()){
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }

    public void setYear(int year){
        if(year >= 0){
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid Year Enterred");
        }
    }

}
