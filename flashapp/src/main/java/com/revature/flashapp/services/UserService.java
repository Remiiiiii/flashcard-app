package com.revature.flashapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.flashapp.models.User;
import com.revature.flashapp.repository.UserRepo;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User createUser(User user){

        if (user.getId() != null) {
            return null;
        }

        return userRepo.save(user);
    }

   
    public User getUserById(Integer userId){
        return userRepo.findById(userId).orElse(null);
    }

    public User updateUserById(User user){
        User userFromDb = userRepo.findById(user.getId()).orElse(null);

        if(userFromDb == null){
            return null;
        }
        return userRepo.save(user);

    }

    public void deleteUserById(Integer userId){
        User userFromDb = userRepo.findById(userId).orElse(null);
        
        if(userFromDb == null)
        return;

        userRepo.deleteById(userId);
    }

    public User getUserByUsername(String username){
        return this.userRepo.findByUsername(username);
    }

    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }
    
    public boolean validateCredentials(User credentials){
        User userFromDb = this.userRepo.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        return userFromDb != null;
    }
}

