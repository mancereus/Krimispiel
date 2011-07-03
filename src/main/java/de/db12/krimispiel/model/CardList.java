package de.db12.krimispiel.model;

import java.util.List;

import com.google.common.collect.Lists;

public class CardList implements CardHolder {
	protected List<Card> cs = Lists.newArrayList();
	
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
