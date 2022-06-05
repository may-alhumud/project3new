package com.example.bookmanagement.controller;


import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.modle.User1;
import com.example.bookmanagement.service.User1Service;
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
@RequestMapping("api/v1/user")
public class User1Controller {
    private final User1Service user1Service;
    Logger logger= LoggerFactory.getLogger(User1Controller.class);


    @GetMapping("/users")
    public ResponseEntity<List<User1>> getUsers(){
        logger.info("get all user");
        List<User1> users=user1Service.getUser1();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/adduser")
    public ResponseEntity<API> addUser(@RequestBody @Valid User1 user1) throws IllegalAccessException{
       logger.info("add user");
        user1Service.addUser1(user1);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New user added !",201));
    }




}
