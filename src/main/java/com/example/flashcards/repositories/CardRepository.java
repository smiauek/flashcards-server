package com.example.flashcards.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flashcards.entities.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

	
	List<CardEntity> findCardByDeckId(Long id);
	

}
