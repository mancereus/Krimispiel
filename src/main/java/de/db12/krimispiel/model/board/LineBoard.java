package de.db12.krimispiel.model.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import de.db12.krimispiel.model.cards.CardList;

public class LineBoard implements Board {
	private static final Logger log = LoggerFactory.getLogger(LineBoard.class);

	protected List<CardField> cm = Lists.newArrayList();
	private CardList trash = new CardList();

	@Override
	public List<CardField> getFreeFields() {
		CardField cardField = new CardField(this);
		cm.add(cardField);
		return Lists.newArrayList(cardField);
	}

	public String toString() {
		return Objects.toStringHelper(this.getClass())
				.add("line: ", Joiner.on(" -> ").join(cm)).toString();

	}

	@Override
	public int getNextMinValue() {
		int maxval = 0;
		for (CardField cf : cm) {
			if (cf.getCard() != null)
				maxval = cf.getCard().getValue();
		}
		return maxval + 1;
	}

	public CardList getTrash() {
		return trash;
	}

	public void setTrash(CardList trash) {
		this.trash = trash;
	}

}
