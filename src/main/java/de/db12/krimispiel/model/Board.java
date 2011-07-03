package de.db12.krimispiel.model;

import java.util.List;

import de.db12.krimispiel.model.cards.Card;
import de.db12.krimispiel.model.cards.CardHolder;

public interface Board extends CardHolder{

	void placeCard(CardField f, Card c);

	List<CardField> getFreeFields();

}
