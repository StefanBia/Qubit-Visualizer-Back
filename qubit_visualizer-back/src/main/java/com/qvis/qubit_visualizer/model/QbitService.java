package com.qvis.qubit_visualizer.model;

import com.qvis.qubit_visualizer.model.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QbitService {
private final QbitRepoUser qbitRepoUser;

@Autowired
    public QbitService(QbitRepoUser qbitRepoUser) {
        this.qbitRepoUser = qbitRepoUser;
    }

    public List<User> getUsers(){
        return qbitRepoUser.findAll();
    }

    public User addUser(User user){
        return qbitRepoUser.save(user);
    }
    public void deleteUser(User user){
        qbitRepoUser.delete(user);
    }
    public User updateUser(User user){
        return qbitRepoUser.save(user);
    }

//    public User findUserByUserId(Long id){
//        return qbitRepoUser.findUserByUserId(id).orElseThrow(() -> new UserNotFoundException("User not found"));
//    }
//    public void deleteUser(Long id){
//        User user = this.findUserByUserId(id);
//        deleteUser(user);
//    }
}
