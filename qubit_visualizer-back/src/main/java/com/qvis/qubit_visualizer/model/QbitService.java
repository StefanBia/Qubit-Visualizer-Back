package com.qvis.qubit_visualizer.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QbitService {

    public List<User> getUsers(){
        return List.of(
                new User(1L,"j","j","j")
        );
    }
}
