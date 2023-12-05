package com.qvis.qubit_visualizer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/qubit")
public class QbitController {
    private final QbitService qbitService;

    @Autowired
    public QbitController(QbitService qbitService) {
        this.qbitService = qbitService;
    }
    @GetMapping
    public List<User> getUsers(){
        return qbitService.getUsers();
    }
}
