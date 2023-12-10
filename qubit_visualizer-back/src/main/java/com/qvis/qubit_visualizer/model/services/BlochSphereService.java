package com.qvis.qubit_visualizer.model.services;

import com.qvis.qubit_visualizer.model.entities.BlochSphere;
import com.qvis.qubit_visualizer.model.exceptions.EntityNotFoundException;
import com.qvis.qubit_visualizer.model.repositories.BlochSphereRepo;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Table(name = "bloch_sphere")
public class BlochSphereService {
    private final BlochSphereRepo blochSphereRepo;

    @Autowired
    public BlochSphereService(BlochSphereRepo blochSphereRepo) {
        this.blochSphereRepo = blochSphereRepo;
    }
    public BlochSphere addBlochSphere(BlochSphere blochSphere){
        return this.blochSphereRepo.save(blochSphere);
    }

    public List<BlochSphere> getAllBlochSpheres(){
        return this.blochSphereRepo.findAll();
    }
    public BlochSphere findBlochSphereByBlochSphereId(Long id){
        return blochSphereRepo.findBlochSphereByBlochSphereId(id).orElseThrow(() -> new EntityNotFoundException("Bloch Sphere not found!"));
    }

    public void deleteBlochSphereById(Long id){
        BlochSphere blochSphere = findBlochSphereByBlochSphereId(id);
        this.blochSphereRepo.delete(blochSphere);
    }

    public BlochSphere updateBlochSphere(BlochSphere blochSphere, Long id){
        BlochSphere newBlochSphere = findBlochSphereByBlochSphereId(id);
        newBlochSphere.setLenX(blochSphere.getLenX());
        newBlochSphere.setLenY(blochSphere.getLenY());
        newBlochSphere.setLenZ(blochSphere.getLenZ());
        return newBlochSphere;
    }
}
