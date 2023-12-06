package com.qvis.qubit_visualizer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qubit")
public class QbitController {
    private final QbitService qbitService;

    @Autowired
    public QbitController(QbitService qbitService) {
        this.qbitService = qbitService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers()
    {
        List<User> users = qbitService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
       User newUser =  qbitService.addUser(user);
       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
