package de.db12.krimispiel.model.board;

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
	public List<CardField> getFreeFields() {
		return Lists.newArrayList(new CardField(3));
	}

	@Override
	public void addCard(Card c) {
		throw new RuntimeException("not needed");
	}

	@Override
	public int getNextMinValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
