package com.revature.flashapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.flashapp.models.User;
import com.revature.flashapp.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User credentials){
        return this.userService.createUser(credentials);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);

    }

    @DeleteMapping("{userId}")
    public String deleteUserById(@PathVariable Integer userId){
        userService.deleteUserById(userId);

        return "User with Id: " + userId + " was deleted if exists";
    }

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("{username}/{password}")//never use this method to validate credentials. Only for example purposes
    public String getByUsernameAndPassword(@PathVariable String username, @PathVariable String password){
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (this.userService.validateCredentials(user)) {
            return "valid credentials";
            
        }else{
            return "invalid username or password";

        }

    }
}
