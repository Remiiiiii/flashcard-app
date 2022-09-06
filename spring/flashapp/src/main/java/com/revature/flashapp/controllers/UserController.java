package com.revature.flashapp.controllers;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> main
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

<<<<<<< HEAD
    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);

    }

    @DeleteMapping("{userId}")
    public String deleteUserById(@PathVariable Integer userId){
        userService.deleteUserById(userId);

        return "User with Id: " + userId + " was deleted if exists";

=======
    @GetMapping("/queryparam")
    public User getUserById(@PathVariable Integer userId){
        return this.userService.getOne(userId);
>>>>>>> main
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

    @PutMapping("{userId}")
    public User updateUser(@PathVariable User user){
        return this.userService.updateOne(user);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteOne(@PathVariable Integer userId){

        this.userService.deleteOne(userId);

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("user with id " + userId + " has been deleted if existed");
    }


    
}
