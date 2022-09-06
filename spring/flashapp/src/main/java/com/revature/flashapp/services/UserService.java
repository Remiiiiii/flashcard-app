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
<<<<<<< HEAD
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
=======
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public List<User> getAllUsers(){
        return this.userDao.findAll();
    }
    
    public User getOne(Integer userId){
        return userDao.findById(userId).orElse(null);
    }
    
    public User updateOne(User user){
        User userFromDb = userDao.findById(user.getId()).orElse(null);

        if(userFromDb == null)
        return null;

        return userDao.save(user);

    }

    public void deleteOne(Integer id){
        User userFromDb = userDao.findById(id).orElse(null);
        
        if(userFromDb == null)
        return;

        userDao.deleteById(id);
>>>>>>> main
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

        if(userFromDb == null)
        return null;

        return userRepo.save(user);

    }

    public void deleteUserById(Integer userId){
        User userFromDb = userRepo.findById(userId).orElse(null);
        
        if(userFromDb == null)
        return;

        userRepo.deleteById(userId);
    }

    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }
    

  

    public boolean validateCredentials(User credentials){
        User userFromDb = userRepo.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());

        return userFromDb != null;
    }
}

