package de.db12.krimispiel.model.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import de.db12.krimispiel.model.cards.Card;

public class LineBoard implements Board {
	private static final Logger log = LoggerFactory.getLogger(LineBoard.class);

	protected List<Card> cm = Lists.newArrayList();
	protected int maxval;

	@Override
	public List<CardField> getFreeFields() {
		return Lists.newArrayList(new CardField(maxval));
	}

	@Override
	public void addCard(Card c) {
		if (c.getValue() <= maxval) {
			log.info("### trash card {}", c);
			return;
		}
		maxval = c.getValue();
		log.info("place card {}", c);
		cm.add(c);
	}

	public String toString() {
		return Objects.toStringHelper(this.getClass())
				.add("line: ", Joiner.on(" -> ").join(cm)).toString();

	}

	@Override
	public int getNextMinValue() {
		return maxval + 1;
	};
}
