package de.db12.krimispiel.model.board;

import java.util.List;

import de.db12.krimispiel.model.cards.Card;
import de.db12.krimispiel.model.cards.CardHolder;

public interface Board extends CardHolder{

	List<CardField> getFreeFields();

	int getNextMinValue();

}
