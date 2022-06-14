package com.example.flashcards.controllers;

import java.rmi.ServerException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.flashcards.entities.CardEntity;
import com.example.flashcards.repositories.CardRepository;

@CrossOrigin
@RestController
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private CardRepository cardRepo;

	@GetMapping("/{id}")
	public List<CardEntity> getCardsByDeckId(@PathVariable Long id) {

		return cardRepo.findCardByDeckId(id);
	}

//	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<CardEntity> create(@RequestBody CardEntity newCard) throws ServerException {
//		System.out.println(newCard);
//		CardEntity card = cardRepo.save(newCard);
//		System.out.println(card);
//		if (card == null) {
//			throw new ServerException("something went wron when creating new card");
//		} else {
//			return new ResponseEntity<CardEntity>(card, HttpStatus.CREATED);
//		}
//	}
	
	@PostMapping("/new")
	public CardEntity newCard(@RequestBody CardEntity newCard) {
		System.out.println(newCard);
		return cardRepo.save(newCard);
	}

}
