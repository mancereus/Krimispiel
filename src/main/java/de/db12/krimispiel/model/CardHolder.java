package de.db12.krimispiel.model;

public interface CardHolder {
	void moveCardTo(Card c, CardHolder holder);

	void addCard(Card c);
}
