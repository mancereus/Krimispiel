package de.db12.krimispiel.model.mover;

import java.util.Collections;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import de.db12.krimispiel.model.Card;
import de.db12.krimispiel.model.Hand;
import de.db12.krimispiel.model.Stack;

public class Spieler implements Mover {
	private static final Logger log = LoggerFactory.getLogger(Spieler.class);
	private String name;
	private Stack stack = new Stack();
	private Hand hand = new Hand();

	public Spieler(String name) {
		this.setName(name);
	}

	void initStack(Integer... i) {
		for (Integer value : i) {
			stack.add(new Card(value));
		}

	}

	@Override
	public void initRound(int round) {
		drawCards(6 - round);
//		log.info("round {}: " + toString());
		putBack(round);
		log.info("round {}: " + toString(), round);
	}

	private void putBack(int round) {
		int cardsback = 3 -round;
		hand.sort();
		for (int i = 0; i < cardsback; i++) {
			Card card = hand.get(hand.size() -1);
			hand.remove(card);
			stack.add(card);
		}
		
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", name).add("hand", Joiner.on(',').join(hand)).toString();
	}
	private void drawCards(int count) {
		for (int i = 0; i < count; i++) {
			Card card = stack.drawRandom();
			hand.add(card);
		}

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
