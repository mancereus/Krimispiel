package de.db12.krimispiel.model.mover;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;

import de.db12.krimispiel.model.board.Board;
import de.db12.krimispiel.model.board.CardField;
import de.db12.krimispiel.model.cards.Card;
import de.db12.krimispiel.model.cards.CardList;
import de.db12.krimispiel.model.cards.Hand;

public class Spieler implements Mover {
	private static final Logger log = LoggerFactory.getLogger(Spieler.class);
	private String name;
	private CardList stack = new CardList();
	private Hand hand = new Hand();

	public Spieler(String name) {
		this.setName(name);
	}

	void initStack(Integer... i) {
		for (Integer value : i) {
			stack.addCard(new Card(value));
		}

	}

	@Override
	public void initRound(int round) {
		drawCards(6 - round);
		// log.info("round {}: " + toString());
		putBack(round);
		log.info("round {}: " + toString(), round);
	}

	private void putBack(int round) {
		int cardsback = 3 - round;
		hand.sort();
		for (int i = 0; i < cardsback; i++) {
			Card card = hand.get(hand.size() - 1);
			hand.moveCardTo(card, stack);
		}

	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", name)
				.add("hand", Joiner.on(',').join(hand)).toString();
	}

	private void drawCards(int count) {
		for (int i = 0; i < count; i++) {
			Card card = stack.drawRandom();
			hand.addCard(card);
		}

	}

	@Override
	public void move(Board board) {
		List<CardField> ff = board.getFreeFields();
		int minmin = Integer.MAX_VALUE;
		CardField minField = null;
		for (CardField f : ff) {
			int min = f.getMinValueAllowed();
			if (min < minmin) {
				minField = f;
				minmin = min;
			}
		}
		if (minField != null) {
			Card minCard = hand.takeMinCard(minmin);
			if (minCard != null)
				board.placeCard(minField, minCard);

		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
