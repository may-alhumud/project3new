package com.example.bookmanagement.repository;

import com.example.bookmanagement.modle.Books;
import com.example.bookmanagement.modle.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User1Repository extends JpaRepository<User1,Integer> {

}
