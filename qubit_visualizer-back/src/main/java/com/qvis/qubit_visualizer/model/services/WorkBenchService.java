package com.qvis.qubit_visualizer.model.services;

import com.qvis.qubit_visualizer.model.entities.User;
import com.qvis.qubit_visualizer.model.entities.WorkBench;
import com.qvis.qubit_visualizer.model.exceptions.EntityNotFoundException;
import com.qvis.qubit_visualizer.model.repositories.WorkBenchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkBenchService {
    private final WorkBenchRepo workBenchRepo;
    @Autowired
    public WorkBenchService(WorkBenchRepo workBenchRepo) {
        this.workBenchRepo = workBenchRepo;
    }

    public List<WorkBench> getAllWorkBenches(){
        List<WorkBench> workBenches = workBenchRepo.findAll();
        return workBenches;
    }

   public WorkBench addWorkBench(WorkBench workBench){
        return workBenchRepo.save(workBench);
   }

   public void deleteWorkBench(WorkBench workBench){
        workBenchRepo.delete(workBench);
   }

   public WorkBench findWorkBenchById(Long id){
        return workBenchRepo.findWorkBenchByWorkBenchId(id).orElseThrow(() -> new EntityNotFoundException("Workbench not found!"));
   }

   public void deleteWorkBenchById(Long id){
        WorkBench workBench = findWorkBenchById(id);
        workBenchRepo.delete(workBench);
   }

   public WorkBench updateWorkBench(WorkBench workBench, Long id){
        WorkBench newWorkBench = this.findWorkBenchById(id);
        newWorkBench.setBlochSpheres(workBench.getBlochSpheres());
         return workBenchRepo.save(newWorkBench);

   }

}
