package de.db12.krimispiel.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import de.db12.krimispiel.model.cards.Card;
import de.db12.krimispiel.model.mover.Spieler;

public class PyramidBoard implements Board {
	private static final Logger log = LoggerFactory.getLogger(Spieler.class);

	protected Map<Integer, List<Card>> cm = Maps.newHashMap();

	@Override
	public void placeCard(CardField f, Card c) {
		log.info("place card {}", c);
	}

	@Override
	public List<CardField> getFreeFields() {
		return Lists.newArrayList(new CardField());
	}

	@Override
	public void addCard(Card c) {
		throw new RuntimeException("not needed");
	}

}
