package com.example.flashcards.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/one/{id}")
	public Optional<CardEntity> getCardByCardId(@PathVariable Long id) {

		return cardRepo.findById(id);
	}

	@PostMapping("/new")
	public ResponseEntity<CardEntity> newCard(@Valid @RequestBody CardEntity newCard) {

		CardEntity savedCard = cardRepo.save(newCard);

		return new ResponseEntity<CardEntity>(savedCard, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CardEntity> updateCard(@PathVariable Long id, @Valid @RequestBody CardEntity updatedCard)
			throws Exception {

		CardEntity cardToUpdate = cardRepo.findById(id).orElseThrow(() -> new Exception("card not found"));

		cardToUpdate.setFront(updatedCard.getFront());
		cardToUpdate.setBack(updatedCard.getBack());

		CardEntity card = cardRepo.save(cardToUpdate);

		return new ResponseEntity<CardEntity>(card, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteCard(@PathVariable Long id) {
		cardRepo.deleteById(id);
	}
}
