package com.revature.flashapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.flashapp.models.Flashcards;
import com.revature.flashapp.repository.FlashcardRepo;

public class FlashcardService {

    private FlashcardRepo flashcardRepo;

    @Autowired
    public FlashcardService(FlashcardRepo flashcardRepo){
        this.flashcardRepo = flashcardRepo;
    }

    public Flashcards createflashcard(Flashcards flashcard){

        if (flashcard.getId() != null) {
            return null;
        }

        return flashcardRepo.save(flashcard);
    }

   
    public Flashcards getflashcardById(Integer flashcardSetId){
        return flashcardRepo.findById(flashcardSetId).orElse(null);
    }

    public Flashcards updateflashcardById(Flashcards flashcard){
        Flashcards flashcardFromDb = flashcardRepo.findById(flashcard.getId()).orElse(null);

        if(flashcardFromDb == null)
        return null;

        return flashcardRepo.save(flashcard);

    }

    public void deleteflashcardById(Integer flashcardId){
        Flashcards flashcardFromDb = flashcardRepo.findById(flashcardId).orElse(null);
        
        if(flashcardFromDb == null)
        return;

        flashcardRepo.deleteById(flashcardId);
    }

    public List<Flashcards> showAllflashcards(){
        return this.flashcardRepo.findAll();
    }
    

    
    
}
