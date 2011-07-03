package de.db12.krimispiel.model;

import java.util.Collections;

public class Hand<T> extends CardList{
	private static final long serialVersionUID = 1L;

	public void sort() {
		Collections.sort(cs);
		
	}

}
