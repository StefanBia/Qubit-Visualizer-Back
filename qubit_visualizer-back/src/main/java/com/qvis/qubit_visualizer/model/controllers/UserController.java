package com.qvis.qubit_visualizer.model.controllers;

import com.qvis.qubit_visualizer.model.entities.BlochSphere;
import com.qvis.qubit_visualizer.model.entities.User;
import com.qvis.qubit_visualizer.model.entities.WorkBench;
import com.qvis.qubit_visualizer.model.services.BlochSphereService;
import com.qvis.qubit_visualizer.model.services.UserService;
import com.qvis.qubit_visualizer.model.services.WorkBenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final WorkBenchService workBenchService;
    private final BlochSphereService blochSphereService;

    @Autowired
    public UserController(UserService userService, WorkBenchService workBenchService, BlochSphereService blochSphereService) {
        this.userService = userService;
        this.workBenchService = workBenchService;
        this.blochSphereService = blochSphereService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers()
    {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user  = userService.findUserByUserId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
       User newUser =  userService.addUser(user);
       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User newUser = userService.updateUser(id,user);
        return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
    }



}
