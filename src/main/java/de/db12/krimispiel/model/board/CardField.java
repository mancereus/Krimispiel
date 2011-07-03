package de.db12.krimispiel.model.board;

import de.db12.krimispiel.model.cards.Card;

public class CardField {

	private int minVal;
	private Card card;

	public Card getCard() {
		return card;
	}

	public CardField(int maxval) {
		minVal = maxval + 1;
	}

	public int getMinValueAllowed() {
		return minVal;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
