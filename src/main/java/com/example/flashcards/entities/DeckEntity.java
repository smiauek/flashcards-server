package com.example.flashcards.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "decks")
public class DeckEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deckId;

	@NotEmpty(message = "deck name must not be empty")
	@Size(min = 3, message = "deck name should have at least 3 characters")
	private String name;

	@NotEmpty(message = "deck description must not be empty")
	@Size(min = 8, message = "deck description should have at least 8 characters")
	private String description;

	private Long userId;

	public DeckEntity() {

	}

	public DeckEntity(String name, String description, Long userId) {

		this.name = name;
		this.description = description;
		this.userId = userId;
	}

	public Long getDeckId() {
		return deckId;
	}

	public void setDeckId(Long deckId) {
		this.deckId = deckId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
