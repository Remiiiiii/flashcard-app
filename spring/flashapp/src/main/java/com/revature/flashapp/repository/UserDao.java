package com.revature.flashapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.flashapp.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> { 

    User findByUsernameAndPassword(String username, String password);
   // User createUser(User user);
}



    

