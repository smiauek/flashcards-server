package com.example.flashcards.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards.entities.CardEntity;
import com.example.flashcards.repositories.CardRepository;

@RestController
@RequestMapping("/cards")
public class CardController {
	
	@Autowired
	private CardRepository cardRepo;
	

	@CrossOrigin
	@GetMapping("/{id}")
	public List<CardEntity> getCardsByDeckId(@PathVariable Long id) {

		return cardRepo.findCardByDeckId(id);
	}

}
