package com.revature.flashapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://127.0.0.1:5500/", allowCredentials = "true")
@RequestMapping(value = "session")
public class SessionController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<JsonResponse> login(HttpSession session, @RequestBody User credentials){
        session.setAttribute("user", credentials);
        if(userService.validateCredentials(credentials)){
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponse("login successful and session created", credentials));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse("login not successful", credentials));
        }
    }

    @GetMapping
    public ResponseEntity<JsonResponse> checkSession(HttpSession session){
        User user = (User) session.getAttribute("user");

        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse("session not found", null));
        }

        return ResponseEntity.ok(new JsonResponse("session found", user));
    }

    @DeleteMapping
    public ResponseEntity<JsonResponse> logout(HttpSession session){

        //session.invalidate();
        session.setAttribute("user", null);

        return ResponseEntity.ok(new JsonResponse("logging out and session invalidated", null));
    }

}