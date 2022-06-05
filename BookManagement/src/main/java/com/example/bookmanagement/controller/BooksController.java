package com.example.bookmanagement.controller;


import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.modle.Books;
import com.example.bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BooksController {
    private final BookService bookService;
    Logger logger= LoggerFactory.getLogger(BooksController.class);

    @GetMapping("/book")
    public ResponseEntity<List<Books>> getBook(){
        logger.info("get all book");
        List<Books> book=bookService.getBook();
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PostMapping("/addbook")
    public ResponseEntity<API> addbook(@RequestBody @Valid Books books){
       logger.info("add book");
        bookService.addBook(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New book added !",201));
    }

}

