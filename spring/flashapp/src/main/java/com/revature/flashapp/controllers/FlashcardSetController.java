package com.revature.flashapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashapp.models.FlashcardSet;
import com.revature.flashapp.services.FlashcardSetService;
import java.util.List;

@RestController
@RequestMapping("flashcardset")
public class FlashcardSetController {

    private FlashcardSetService flashcardSetService;

    @Autowired
    public FlashcardSetController(FlashcardSetService flashcardSetService){
        this.flashcardSetService = flashcardSetService;
    }

    @PostMapping
    public FlashcardSet createflashcardSet(@RequestBody FlashcardSet cardInfo){
        return flashcardSetService.createFlashcardSet(cardInfo);
    }

    @GetMapping("{userId}")
    public List<FlashcardSet> getflashcardSetByUserId(@PathVariable Integer userId){
        return flashcardSetService.getflashcardSetByUserId(userId);

    }

    @DeleteMapping("{setId}")
    public String deleteFlashcardSetById(@PathVariable Integer setId){
        flashcardSetService.deleteFlashcardSetById(setId);
        

        return "Flashcard Set with Id: " + setId + " was deleted if exists";
    }

    @GetMapping
    public List<FlashcardSet> showAllSets(){
        return this.flashcardSetService.showAllSets();
    }
    
}
