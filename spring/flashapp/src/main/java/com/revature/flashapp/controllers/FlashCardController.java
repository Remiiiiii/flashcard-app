package com.revature.flashapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.flashapp.models.Flashcards;
import com.revature.flashapp.services.FlashcardService;
import java.util.List;


public class FlashCardController {

    private FlashcardService flashcardService;

    @Autowired
    public FlashCardController(FlashcardService flashcardService){
        this.flashcardService = flashcardService;
    }

    @PostMapping
    public Flashcards createflashcard(@RequestBody Flashcards cardInfo){
        return this.flashcardService.createflashcard(cardInfo);
    }

    @GetMapping("{flashcardId}")
    public Flashcards getflashcardById(@PathVariable Integer flashcardId){
        return flashcardService.getflashcardById(flashcardId);

    }

    @DeleteMapping("{flashcardId}")
    public String deleteflashcardById(@PathVariable Integer flashcardId){
        flashcardService.deleteflashcardById(flashcardId);

        return "Flashcard  with Id: " + flashcardId + " was deleted if exists";
    }

    @GetMapping
    public List<Flashcards> getAllflashcard(){
        return this.flashcardService.showAllflashcards();
    }
}
