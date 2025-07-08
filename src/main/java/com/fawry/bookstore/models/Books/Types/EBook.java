package com.fawry.bookstore.models.Books.Types;

import com.fawry.bookstore.models.Books.Mailable;
import com.fawry.bookstore.models.Books.PurchasableBook;

public class EBook extends PurchasableBook implements Mailable {
    private String filetype;
    
    public EBook(String ISBN, String title, int year, double price, String FileType){
        super(ISBN, title, year, price);
        setFileType(FileType);
    }

    public String getFileType(){
        return filetype;
    }

    public void setFileType(String filetype){
        if(!filetype.isEmpty()){
            this.filetype = filetype;
        } else {
            throw new IllegalArgumentException("File type cannot be empty");
        }
    }
}
