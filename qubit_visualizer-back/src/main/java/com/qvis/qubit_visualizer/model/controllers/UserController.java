package com.qvis.qubit_visualizer.model.controllers;

import com.qvis.qubit_visualizer.model.AuthCredentialsRequest;
import com.qvis.qubit_visualizer.model.LoginResponse;
import com.qvis.qubit_visualizer.model.entities.BlochSphere;
import com.qvis.qubit_visualizer.model.entities.User;
import com.qvis.qubit_visualizer.model.entities.WorkBench;
import com.qvis.qubit_visualizer.model.exceptions.BadCredentialsException;
import com.qvis.qubit_visualizer.model.services.BlochSphereService;
import com.qvis.qubit_visualizer.model.services.UserService;
import com.qvis.qubit_visualizer.model.services.WorkBenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthCredentialsRequest request) {
        User user = userService.findUserByUsername(request.getUsername());
        System.out.println(user.getPassword());
        LoginResponse response = new LoginResponse();

        try {
            if (user != null && request.getPassword().equals(user.getPassword())) {
                response.setStatus(HttpStatus.ACCEPTED);

                Set<WorkBench> workBenches = user.getWorkBenches();
                if (workBenches != null && !workBenches.isEmpty()) {
                    Iterator<WorkBench> iterator = workBenches.iterator();
                    WorkBench workBench = iterator.next();
                    response.setSelectedGate(workBench.getSelectedGate());
                } else {
                    response.setSelectedGate("Pauli-X"); // Provide a default value if workBenches is null or empty
                }
            } else {
                throw new BadCredentialsException("Incorrect password!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.setStatus(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }

}
