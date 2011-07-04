package de.db12.krimispiel.model.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

import de.db12.krimispiel.model.cards.Card;
import de.db12.krimispiel.model.cards.CardHolder;

public class CardField implements CardHolder {
	private static final Logger log = LoggerFactory.getLogger("cf");

	private Card card;
	private List<CardField> parents = Lists.newArrayList();
	private Board board;

	public Card getCard() {
		return card;
	}

	public CardField(Board board) {
		this.board = board;
	}

	public boolean isFreeToUse() {
		if (getCard() != null)
			return false;
		for (CardField par : parents) {
			if (par.getCard() == null)
				return false;
		}
		return true;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public void addParent(CardField cardField) {
		parents.add(cardField);

	}

	@Override
	public String toString() {
		if (getCard() == null)
			return "...";
		return getCard().toString();
	}

	public List<CardField> getParents() {
		return parents;

	}

	@Override
	public void addCard(Card c) {
		int minValue = board.getNextMinValue();
		if (c.getValue() < minValue) {
			log.info("### trash card {}", c);
			return;
		}
		log.info("place card {}", c);
		setCard(c);

	}

	public int getNeededValue() {
		if (parents == null || parents.size() == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		for (CardField parent : parents) {
			if (parent.getCard() != null)
				min = Math.min(parent.getCard().getValue(), min);
		}
		return min;
	}

}
