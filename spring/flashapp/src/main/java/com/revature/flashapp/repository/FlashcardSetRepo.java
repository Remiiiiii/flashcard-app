package com.revature.flashapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.flashapp.models.FlashcardSet;


@Repository
public interface FlashcardSetRepo extends JpaRepository<FlashcardSet, Integer>  {
 
 

    // List<FlashcardSet> showAllSets();

    // void createflashcardSet();

    // void deleteFlashcardSetById(Integer setId);

    List<FlashcardSet> findAllSetsById(Integer setId);
}
