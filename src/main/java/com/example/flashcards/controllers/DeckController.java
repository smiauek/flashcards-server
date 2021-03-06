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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashcards.entities.DeckEntity;
import com.example.flashcards.repositories.DeckRepository;

@CrossOrigin
@RestController
@RequestMapping("/decks")
public class DeckController {

	@Autowired
	private DeckRepository deckRepo;

	@GetMapping("/")
	public List<DeckEntity> getAllDecks() {
		return deckRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<DeckEntity> getDeckById(@PathVariable Long id) {

		return deckRepo.findById(id);
	}

	@GetMapping("/user/{id}")
	public List<DeckEntity> getUserDecks(@PathVariable Long id) {

		return deckRepo.findByUserId(id);
	}

	@GetMapping("/find")
	public List<DeckEntity> findDecks(@RequestParam String searchTerm) {

		return deckRepo.findByNameContainsOrDescriptionContains(searchTerm, searchTerm);
	}

	@PostMapping("/new")
	public ResponseEntity<DeckEntity> createDeck(@Valid @RequestBody DeckEntity deck) {

		DeckEntity savedDeck = deckRepo.save(deck);

		return new ResponseEntity<DeckEntity>(savedDeck, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<DeckEntity> updateDeck(@PathVariable Long id, @Valid @RequestBody DeckEntity updatedDeck)
			throws Exception {

		DeckEntity deckToUpdate = deckRepo.findById(id).orElseThrow(() -> new Exception("deck not found"));

		deckToUpdate.setName(updatedDeck.getName());
		deckToUpdate.setDescription(updatedDeck.getDescription());

		DeckEntity deck = deckRepo.save(deckToUpdate);

		return new ResponseEntity<DeckEntity>(deck, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteDeck(@PathVariable Long id) {
		deckRepo.deleteById(id);
	}

}
