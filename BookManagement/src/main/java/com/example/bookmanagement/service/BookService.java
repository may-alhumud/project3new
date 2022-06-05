package com.example.bookmanagement.service;

import com.example.bookmanagement.modle.Books;
import com.example.bookmanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;



    public List<Books> getBook() {

        return  bookRepository.findAll();
    }

    public void addBook(Books books)  {

        bookRepository.save(books);
    }


}
