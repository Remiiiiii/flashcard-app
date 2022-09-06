package com.revature.flashapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashapp.models.FlashcardSet;
import com.revature.flashapp.models.User;
import com.revature.flashapp.services.FlashcardSetService;
import java.util.List;

public class FlashcardSetController {

    private FlashcardSetService flashcardSetService;

    @Autowired
    public FlashcardSetController(FlashcardSetService flashcardSetService){
        this.flashcardSetService = flashcardSetService;
    }

    @PostMapping
    public FlashcardSet createflashcardSet(@RequestBody FlashcardSet cardInfo){
        return this.flashcardSetService.createflashcardSet(cardInfo);
    }

    @GetMapping("{setId}")
    public FlashcardSet getflashcardSetById(@PathVariable Integer setId){
        return flashcardSetService.getflashcardSetById(setId);

    }

    @DeleteMapping("{setId}")
    public String deleteflashcardSetById(@PathVariable Integer setId){
        flashcardSetService.deleteflashcardSetById(setId);

        return "Flashcard Set with Id: " + setId + " was deleted if exists";
    }


 
    @GetMapping
    public List<FlashcardSet> getAllflashcardSets(){
        return this.flashcardSetService.getAllflashcardSets();
    }


    
}
