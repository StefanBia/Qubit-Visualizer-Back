package com.qvis.qubit_visualizer.model.services;

import com.qvis.qubit_visualizer.model.repositories.UserRepo;
import com.qvis.qubit_visualizer.model.entities.User;
import com.qvis.qubit_visualizer.model.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
private final UserRepo userRepo;

@Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User addUser(User user){
        return userRepo.save(user);
    }
    public void deleteUser(User user){
        userRepo.delete(user);
    }
    public User updateUser(Long id, User user){
        User newUser = findUserByUserId(id);
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return userRepo.save(newUser);
    }

    public User findUserByUserId(Long id){
        return userRepo.findUserByUserId(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }
    public void deleteUser(Long id){
        User user = this.findUserByUserId(id);
        deleteUser(user);
    }

    public User findUserByUsername(String username){
        return userRepo.findUserByUsername(username).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }
}
