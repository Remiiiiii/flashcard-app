package com.revature.flashapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashapp.models.JsonResponse;
import com.revature.flashapp.models.User;
//import com.revature.flashapp.repository.UserRepo;
import com.revature.flashapp.services.UserService;

@RestController
@RequestMapping(value = "session")
public class SessionController {

    private UserService userService;

    @Autowired
    public SessionController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<JsonResponse> login(HttpSession session, @RequestBody User credentials){
        
        if(userService.validateCredentials(credentials)){
            User userFromDb = userService.getUserByUsername(credentials.getUsername());
            session.setAttribute("user", userFromDb);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponse(true, "login successful and session created", credentials));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(false, "login not successful", credentials));
        }
    }

    @GetMapping
    public ResponseEntity<JsonResponse> checkSession(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(false, "session not found", null));
        }

        return ResponseEntity.ok(new JsonResponse(true, "session found", user));
    }

    @DeleteMapping
    public ResponseEntity<JsonResponse> logout(HttpSession session){

        //session.invalidate();
        session.setAttribute("user", null);

        return ResponseEntity.ok(new JsonResponse(true, "logging out and session invalidated", null));
    }

}