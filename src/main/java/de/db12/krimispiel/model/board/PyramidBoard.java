package de.db12.krimispiel.model.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import de.db12.krimispiel.model.cards.Card;
import de.db12.krimispiel.model.cards.CardList;
import de.db12.krimispiel.model.mover.Spieler;

public class PyramidBoard implements Board {
	private static final Logger log = LoggerFactory.getLogger("pb");

	protected Map<Integer, List<CardField>> cm = Maps.newHashMap();
	private CardList trash = new CardList();

	public PyramidBoard() {
		for (int i = 0; i < 7; i++) {
			ArrayList<CardField> rowlist = new ArrayList<CardField>();
			cm.put(i, rowlist);
			for (int j = 0; j < i + 1; j++) {
				CardField cf = new CardField(this);
				rowlist.add(cf);
				addParents(cf, i, j, i + 1);
			}
		}

	}

	private void addParents(CardField cf, int row, int col, int rowsize) {
		if (row == 0)
			return;
		if (col > 0)
			cf.addParent(getCardField(row - 1, col - 1));
		if (col < rowsize - 1)
			cf.addParent(getCardField(row - 1, col + 1));

	}

	private CardField getCardField(int row, int col) {
		return cm.get(row).get(col);
	}

	@Override
	public List<CardField> getFreeFields() {
		return Lists.newArrayList(new CardField(this));
	}

	@Override
	public int getNextMinValue() {
		int min = Integer.MAX_VALUE;
		for (List<CardField> row : cm.values()) {
			for (CardField cardField : row) {
				if(cardField.isFreeToUse()) {
					List<CardField> parents = cardField.getParents();
					for (CardField cf : parents) {
						if(cf.getCard().getValue() < min) {
							min = cf.getCard().getValue()+1;
						}
					}
				}
			}
		}
		return min;
	}
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer("\n");
		for (List<CardField> row : cm.values()) {
			buf.append(Joiner.on(" - ").join(row) + "\n");
		}
		return super.toString();
	}

	public CardList getTrash() {
		return trash;
	}

	public void setTrash(CardList trash) {
		this.trash = trash;
	}

}
