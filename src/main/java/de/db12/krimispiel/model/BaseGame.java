package de.db12.krimispiel.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.db12.krimispiel.model.board.Board;
import de.db12.krimispiel.model.mover.Mover;
import de.db12.krimispiel.model.mover.Spieler;

public abstract class BaseGame implements Game {
	private static final Logger log = LoggerFactory.getLogger(Spieler.class);

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
		if (phasecount == 3)
			return true;
		return false;
	}

	protected void endRound() {
		round++;
		log.info(board.toString());
	}

	@Override
	public void initRound() {
		phasecount  = 0;
		for (Mover mover : getMover()) {
			mover.initRound(round, board.getNextMinValue());
		}

	}

}
