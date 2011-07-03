package de.db12.krimispiel.model.cards;


public class Card implements Comparable<Card> {
	String name;
	Integer value;

	public Card(Integer value) {
		this.value = value;
	}

	@Override
	public int compareTo(Card o) {
		return value.compareTo(o.value);
	}
	@Override
	public String toString() {
		return value + ":00";
	}
	
}
