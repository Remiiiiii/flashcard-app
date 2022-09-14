package com.revature.flashapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.flashapp.models.FlashcardSet;
import com.revature.flashapp.repository.FlashcardSetRepo;


@Service
@Transactional
public class FlashcardSetService {

    private FlashcardSetRepo flashcardSetRepo;

    @Autowired
    public FlashcardSetService(FlashcardSetRepo flashcardSetRepo){
        this.flashcardSetRepo = flashcardSetRepo;
    }

    public FlashcardSet createFlashcardSet(FlashcardSet flashcardSet){

        if (flashcardSet.getId() != null) {
            return null;
        }

        return flashcardSetRepo.save(flashcardSet);
    }

   
    public List<FlashcardSet> getflashcardSetByUserId(Integer userId){
        return flashcardSetRepo.findAllSetsByUserId(userId);
    }

    public FlashcardSet updateflashcardSetById(FlashcardSet flashcardSet){
        FlashcardSet flashcardSetFromDb = flashcardSetRepo.findById(flashcardSet.getId()).orElse(null);

        if(flashcardSetFromDb == null)
        return null;

        return flashcardSetRepo.save(flashcardSet);

    }

    public void deleteFlashcardSetById(Integer flashcardSetId){
        FlashcardSet flashcardSetFromDb = flashcardSetRepo.findById(flashcardSetId).orElse(null);

        
        if(flashcardSetFromDb == null){
            return;
        }
        

        flashcardSetRepo.deleteById(flashcardSetId);
    }

    public List<FlashcardSet> showAllSets(){
        return this.flashcardSetRepo.findAll();
    }
    
    // public boolean validateFlashcardSet(FlashcardSet cardInfo){
    //     FlashcardSet flashcardSetFromDb = flashcardSetRepo.createFlashcardSet(cardInfo.getTitle(), cardInfo.getDescription(), cardInfo.getUser());

    //     return flashcardSetFromDb != null;
    // }

   


    
}
