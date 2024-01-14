package com.qvis.qubit_visualizer.model.controllers;

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
@RequestMapping("/workbench")
@CrossOrigin("http://localhost:3000")
public class WorkBenchController {
    private final UserService userService;
    private final WorkBenchService workBenchService;
    private final BlochSphereService blochSphereService;

    @Autowired
    public WorkBenchController(UserService userService, WorkBenchService workBenchService, BlochSphereService blochSphereService) {
        this.userService = userService;
        this.workBenchService = workBenchService;
        this.blochSphereService = blochSphereService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<WorkBench>> getWorkBenches(){
        List<WorkBench> workBenches = workBenchService.getAllWorkBenches();
        return new ResponseEntity<>(workBenches, HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<WorkBench> addWorkBench(@PathVariable("id") Long id, @RequestBody WorkBench workBench){
        User user = userService.findUserByUserId(id);
        WorkBench newWorkBench = workBenchService.addWorkBench(workBench);
        user.addWorkBench(newWorkBench);
        userService.updateUser(user.getUserId(),user);
        return new ResponseEntity<>(newWorkBench,HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWorkBench(@PathVariable ("id") Long id){
        workBenchService.deleteWorkBenchById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<WorkBench> updateWorkBench(@PathVariable("id") Long id, @RequestBody WorkBench workBench){
        WorkBench newWorkBench =  workBenchService.updateWorkBench(workBench,id);
        return new ResponseEntity<>(newWorkBench,HttpStatus.OK);
    }
}
