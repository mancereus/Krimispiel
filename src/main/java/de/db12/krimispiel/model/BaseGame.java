package de.db12.krimispiel.model;

import java.util.List;

import de.db12.krimispiel.model.board.Board;
import de.db12.krimispiel.model.mover.Mover;

public abstract class BaseGame implements Game {
	protected Board board;
	protected List<Mover> mover;

	protected int round = 0;
	private int phasecount = 0;

	public void start() {
		init();
		while (!isFinished()) {
			playRound();
		}
		Mover mv = getWinner();
		showWin(mv);
	}

	private void playRound() {
		List<Mover> mover = getMover();
		while (!isFinished()) {
			initRound();
			while (!isRoundFinished()) {
				for (Mover mv : mover) {
					mv.move(board);
					if (isFinished())
						break;
				}
				phasecount++;
			}
			endRound();
		}
	}

	@Override
	public boolean isFinished() {
		return round == 3;
	}


	protected boolean isRoundFinished() {
		if (phasecount == 1)
			return true;
		return false;
	}

	protected void endRound() {
		round++;
	}

	@Override
	public void initRound() {
		phasecount  = 0;
		for (Mover mover : getMover()) {
			mover.initRound(round);
		}

	}

}
