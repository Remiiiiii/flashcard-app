package com.revature.flashapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.flashapp.models.Flashcards;

@Repository
public interface FlashcardRepo extends JpaRepository<Flashcards, Integer> {
   

}
