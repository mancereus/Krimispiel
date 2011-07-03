package de.db12.krimispiel.model;

import java.util.HashSet;

import com.google.common.collect.Sets;

public class CardSet implements CardHolder {
	protected HashSet<Card> cs = Sets.newHashSet();
	
	public Card dramRandom() {
		if (cs.isEmpty())
			return null;
		return cs.iterator().next();
	}

	@Override
	public void moveCardTo(Card c, CardHolder holder) {
		if (!cs.contains(c))
			return;
		cs.remove(c);
		holder.addCard(c);
	}

	@Override
	public void addCard(Card c) {
		cs.add(c);
		
	}
}
