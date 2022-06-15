package com.example.flashcards.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "decks")
public class DeckEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deckId;

	private String name;
	private String description;

//	@ManyToOne
	//@JoinColumn(name = "userId")
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
