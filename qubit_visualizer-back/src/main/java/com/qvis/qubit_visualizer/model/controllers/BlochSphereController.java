package com.qvis.qubit_visualizer.model.controllers;

import com.qvis.qubit_visualizer.model.entities.BlochSphere;
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
@RequestMapping("/blochsphere")
public class BlochSphereController {

    private final UserService userService;
    private final WorkBenchService workBenchService;
    private final BlochSphereService blochSphereService;

    @Autowired
    public BlochSphereController(UserService userService, WorkBenchService workBenchService, BlochSphereService blochSphereService) {
        this.userService = userService;
        this.workBenchService = workBenchService;
        this.blochSphereService = blochSphereService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlochSphere>> getBlochSpheres(){
        List<BlochSphere> blochSpheres = this.blochSphereService.getAllBlochSpheres();
        return new ResponseEntity<>(blochSpheres, HttpStatus.OK);
    }

    @PostMapping("add/{id}")
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBlochSphere(@PathVariable Long id){
        this.blochSphereService.deleteBlochSphereById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BlochSphere> updateBlochSphere(@PathVariable Long id, @RequestBody BlochSphere blochSphere){
        BlochSphere newBlochSphere = this.blochSphereService.updateBlochSphere(blochSphere,id);
        return new ResponseEntity<>(newBlochSphere,HttpStatus.OK);
    }
}
