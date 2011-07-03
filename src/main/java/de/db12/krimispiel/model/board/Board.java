package de.db12.krimispiel.model.board;

import java.util.List;

import de.db12.krimispiel.model.cards.Card;
import de.db12.krimispiel.model.cards.CardHolder;
import de.db12.krimispiel.model.cards.CardList;

public interface Board{

	List<CardField> getFreeFields();

	int getNextMinValue();

	CardList getTrash();

}
