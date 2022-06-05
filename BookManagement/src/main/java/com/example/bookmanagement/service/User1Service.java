package com.example.bookmanagement.service;

import com.example.bookmanagement.modle.User1;
import com.example.bookmanagement.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class User1Service {
    private final User1Repository user1Repository;

    public List<User1> getUser1() {

        return  user1Repository.findAll();
    }

    public void addUser1(User1 user1)  {

        user1Repository.save(user1);
    }

}
