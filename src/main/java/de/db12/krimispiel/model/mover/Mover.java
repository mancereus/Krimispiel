package de.db12.krimispiel.model.mover;

import de.db12.krimispiel.model.Board;

public interface Mover {
	public void move(Board board);

	void initRound(int round);
}
