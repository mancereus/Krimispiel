package de.db12.krimispiel.model.cards;

public interface CardStack extends CardHolder{
	void moveCardTo(Card c, CardHolder holder);

	void addCard(Card c);

	Card drawRandom();

	int size();
}
