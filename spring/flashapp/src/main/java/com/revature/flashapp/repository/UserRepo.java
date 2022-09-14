package com.revature.flashapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.flashapp.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> { 

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    //User createUser(User user);
    //User getUserById(Integer user_id);
}



    

