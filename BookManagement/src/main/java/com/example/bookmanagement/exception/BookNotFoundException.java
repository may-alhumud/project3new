package com.example.bookmanagement.exception;

import lombok.AllArgsConstructor;


public class BookNotFoundException extends Exception {

    public BookNotFoundException(String msg){

        super(msg);
    }


}
