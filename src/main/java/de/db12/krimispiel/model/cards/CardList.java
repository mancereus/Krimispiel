package de.db12.krimispiel.model.cards;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class CardList implements CardStack, Iterable<Card> {
	protected List<Card> cs = Lists.newArrayList();
	private Random random = new Random();

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

	@Override
	public Card drawRandom() {
		int rnd = random.nextInt(cs.size());
		Card card = cs.get(rnd);
		cs.remove(card);

		return card;
	}

	@Override
	public Iterator<Card> iterator() {
		return cs.iterator();
	}

	@Override
	public int size() {
		return cs.size();
	}
}