package com.example.bookmanagement.repository;

import com.example.bookmanagement.modle.Books;
import com.example.bookmanagement.modle.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {
}
