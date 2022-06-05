package com.example.bookmanagement.service;

import com.example.bookmanagement.exception.BookNotFoundException;
import com.example.bookmanagement.modle.Books;
import com.example.bookmanagement.modle.Loan;
import com.example.bookmanagement.modle.User1;
import com.example.bookmanagement.repository.BookRepository;
import com.example.bookmanagement.repository.LoanRepository;
import com.example.bookmanagement.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final User1Repository user1Repository;

    public List<Loan> getLoan() {

        return  loanRepository.findAll();
    }

    public void addLoan(Loan loan)  {

        loanRepository.save(loan);
    }

    public void addLoanBook(@PathVariable Integer bookid, @PathVariable Integer loanid){
        Loan loan=loanRepository.findById(loanid).get();
        Books books=bookRepository.findById(bookid).get();
        loan.getBooks().add(books);
        loanRepository.save(loan);
        loanRepository.findAll();
    }

    public boolean loanBook(Loan loan) {

        var user = user1Repository.findById(loan.getUserid());
        if(user.isEmpty()){
            return false;
        }
        var currentBook = bookRepository.findById(loan.getBookid());
        if(currentBook.isEmpty()){
            return false;
        }
        loanRepository.save(loan);
        return true;
    }

    public List<Loan> lendedBooks(Integer bookid) throws BookNotFoundException {
        var book=bookRepository.findById(bookid);
        if (book.isEmpty()){
            throw new BookNotFoundException("BOOK WITH ID "+ bookid +" NOT FOUND");
        }
        return loanRepository.findAllByBookid(bookid);
    }

}
