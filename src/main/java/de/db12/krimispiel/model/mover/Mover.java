package de.db12.krimispiel.model.mover;

import de.db12.krimispiel.model.board.Board;

public interface Mover {
	public void move(Board board);

	void initRound(int round);
}
