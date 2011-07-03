package de.db12.krimispiel.model;

import java.util.List;

import de.db12.krimispiel.model.mover.Mover;

public interface Game {
	void init();

	void initRound();

	List<Mover> getMover();

	boolean isFinished();
	
	Mover getWinner();
	
	void showWin(Mover mv);
}
