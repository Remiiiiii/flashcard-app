package com.revature.flashapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.flashapp.models.User;
import com.revature.flashapp.repository.UserDao;

@Service
@Transactional
public class UserService {

    private UserDao userDao;

    @Autowired
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
    }

    public User createUser(User user){

        if (user.getId() != null) {
            return null;
            
        }
        return userDao.save(user);
    }

    public boolean validateCredentials(User credentials){
        User userFromDb = userDao.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());

        return userFromDb != null;
    }
}

