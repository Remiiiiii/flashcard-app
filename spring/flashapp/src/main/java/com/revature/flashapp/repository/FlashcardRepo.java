package com.revature.flashapp.repository;

import com.revature.flashapp.models.Flashcards;

@Repository
public interface FlashcardRepo extends JpaRepository<Flashcards, Integer> {
   

}
