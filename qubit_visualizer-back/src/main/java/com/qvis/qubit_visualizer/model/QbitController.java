package com.qvis.qubit_visualizer.model;

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
@RequestMapping("/qubit")
public class QbitController {
    private final UserService userService;
    private final WorkBenchService workBenchService;
    private final BlochSphereService blochSphereService;

    @Autowired
    public QbitController(UserService userService, WorkBenchService workBenchService, BlochSphereService blochSphereService) {
        this.userService = userService;
        this.workBenchService = workBenchService;
        this.blochSphereService = blochSphereService;
    }
    @GetMapping("/all/user")
    public ResponseEntity<List<User>> getUsers()
    {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user  = userService.findUserByUserId(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PostMapping("/add/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
       User newUser =  userService.addUser(user);
       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User newUser = userService.updateUser(id,user);
        return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all/workbench")
    public ResponseEntity<List<WorkBench>> getWorkBenches(){
        List<WorkBench> workBenches = workBenchService.getAllWorkBenches();
        return new ResponseEntity<>(workBenches,HttpStatus.OK);
    }

    @PostMapping("/add/workbench/{id}")
    public ResponseEntity<WorkBench> addWorkBench(@PathVariable("id") Long id, @RequestBody WorkBench workBench){
        User user = userService.findUserByUserId(id);
        WorkBench newWorkBench = workBenchService.addWorkBench(workBench, user);
        return new ResponseEntity<>(newWorkBench,HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/workbench/{id}")
    public ResponseEntity<?> deleteWorkBench(@PathVariable ("id") Long id){
        workBenchService.deleteWorkBenchById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/workbench/{id}")
    public ResponseEntity<WorkBench> updateWorkBench(@PathVariable("id") Long id, @RequestBody WorkBench workBench){
        WorkBench newWorkBench =  workBenchService.updateWorkBench(workBench,id);
        return new ResponseEntity<>(newWorkBench,HttpStatus.OK);
    }

    @GetMapping("/all/blochsphere")
    public ResponseEntity<List<BlochSphere>> getBlochSpheres(){
        List<BlochSphere> blochSpheres = this.blochSphereService.getAllBlochSpheres();
        return new ResponseEntity<>(blochSpheres,HttpStatus.OK);
    }

    @PostMapping("add/blochsphere/{id}")
    public ResponseEntity<BlochSphere> addBlochSphere(@PathVariable("id") Long id, @RequestBody BlochSphere blochSphere){
        BlochSphere newBlochSphere = this.blochSphereService.addBlochSphere(blochSphere);

        // Find the WorkBench by ID
        WorkBench workBench = this.workBenchService.findWorkBenchById(id);

        // Add the new BlochSphere to the WorkBench
        workBench.addBlochSphere(newBlochSphere);

        // Save the changes to the database
        this.workBenchService.addWorkBench(workBench, workBench.getUser());

        return new ResponseEntity<>(newBlochSphere,HttpStatus.OK);
    }

    @DeleteMapping("/delete/blochsphere/{id}")
    public ResponseEntity<?> deleteBlochSphere(@PathVariable Long id){
        this.blochSphereService.deleteBlochSphereById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/blochsphere/{id}")
    public ResponseEntity<BlochSphere> updateBlochSphere(@PathVariable Long id, @RequestBody BlochSphere blochSphere){
        BlochSphere newBlochSphere = this.blochSphereService.updateBlochSphere(blochSphere,id);
        return new ResponseEntity<>(newBlochSphere,HttpStatus.OK);
    }

}
