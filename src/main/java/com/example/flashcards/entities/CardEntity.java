package com.example.flashcards.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class CardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardId;

	private String front;
	private String back;

//	@ManyToOne
	private Long deckId;

	public CardEntity() {

	}

	public CardEntity(String front, String back, Long deckId) {

		this.front = front;
		this.back = back;
		this.deckId = deckId;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public Long getDeckId() {
		return deckId;
	}

	public void setDeckId(Long deckId) {
		this.deckId = deckId;
	}

	@Override
	public String toString() {
		return "CardEntity [cardId=" + cardId + ", front=" + front + ", back=" + back + ", deckId=" + deckId + "]";
	}

}
