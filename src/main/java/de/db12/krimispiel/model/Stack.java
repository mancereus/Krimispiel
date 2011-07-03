package de.db12.krimispiel.model;

import java.util.Random;


public class Stack extends CardSet {
	private static final long serialVersionUID = 1L;
	Random random = new Random();

	public Card drawRandom() {
		int rnd = random.nextInt(cs.size());
		Card card = cs.get(rnd);
		cs.remove(card);

		return card;
	}
}
