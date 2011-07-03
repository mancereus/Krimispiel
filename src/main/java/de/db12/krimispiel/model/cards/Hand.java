package de.db12.krimispiel.model.cards;

import java.util.Collections;


public class Hand<T> extends CardList{
	private static final long serialVersionUID = 1L;

	public void sort() {
		Collections.sort(cs);
	}

	public Card get(int i) {
		return cs.get(i);
	}

	public Card takeMinCard(int min) {
		sort();
		for (Card c : cs) {
			if(c.value >= min)
				cs.remove(c);
				return c;
		}
		return null;
		
	}

}
