package com.revature.flashapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.flashapp.models.FlashcardSet;


@Repository
public interface FlashcardSetRepo extends JpaRepository<FlashcardSet, Integer>  {

    
}
