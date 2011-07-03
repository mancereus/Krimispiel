package de.db12.krimispiel.model.board;

public class CardField {

	private int minVal;

	public CardField(int maxval) {
		minVal = maxval +1;
	}

	public int getMinValueAllowed() {
		return minVal;
	}

}
