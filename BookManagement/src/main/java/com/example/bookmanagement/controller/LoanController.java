package com.example.bookmanagement.controller;


import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.exception.BookNotFoundException;
import com.example.bookmanagement.modle.Books;
import com.example.bookmanagement.modle.Loan;
import com.example.bookmanagement.service.BookService;
import com.example.bookmanagement.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loan")
public class LoanController {
    private final LoanService loanService;
    Logger logger= LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/loan")
    public ResponseEntity<List<Loan>> getloan(){
        logger.info("get All loan");
        List<Loan> loans=loanService.getLoan();
        return ResponseEntity.status(HttpStatus.OK).body(loans);
    }

    @PostMapping("/addLoan")
    public ResponseEntity<API> addLoan(@RequestBody @Valid Loan loan){
        logger.info("Add loan");
        loanService.addLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New book added !",201));
    }

    @PostMapping("loan/{bookid}/{loanid}")
    public ResponseEntity addLoanBook(@PathVariable Integer bookid,@PathVariable Integer loanid){
       logger.info("collect information from book and loan ");
        loanService.addLoanBook(bookid,loanid);
        return ResponseEntity.status(HttpStatus.OK).body(  new API("New book added !",201));
    }


    @PostMapping("/loanBook")
    public ResponseEntity<API> LoanBook(@RequestBody @Valid Loan loan, Errors errors){
        logger.info("loan book");
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new API(errors.getFieldError().getDefaultMessage(),400));
        }
        var add=loanService.loanBook(loan);
        if(!add){
            return ResponseEntity.status(400).body(new API("Invalid book id or user id",400));
        }
        logger.info("New load is added to database");
        //LoggerFactory.getLogger(LoanController.class).info("New load is added to database");
        return ResponseEntity.status(201).body(new API("New loan added",201));
    }

    @GetMapping("/lendedBooks/{bookid}")
    public ResponseEntity lendedBooks(@PathVariable Integer bookid){
        logger.info("lended book");
        try {
            var any  = this.loanService.lendedBooks(bookid);
            return ResponseEntity.status(201).body(any);
        } catch (BookNotFoundException e) {
            LoggerFactory.getLogger(LoanController.class).error(e.getMessage());
        }

        return ResponseEntity.status(400).body("Invalid book id or user id");
    }

}
