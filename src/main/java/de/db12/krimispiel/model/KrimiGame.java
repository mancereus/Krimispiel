package de.db12.krimispiel.model;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import de.db12.krimispiel.GameModule;
import de.db12.krimispiel.model.board.Board;
import de.db12.krimispiel.model.mover.Ermittler;
import de.db12.krimispiel.model.mover.Kommisar;
import de.db12.krimispiel.model.mover.Mover;
import de.db12.krimispiel.model.mover.PrivatDetektiv;
import de.db12.krimispiel.model.mover.Spieler;
import de.db12.krimispiel.model.mover.Staatsanwalt;

public class KrimiGame extends BaseGame {

	@Inject
	public KrimiGame(Board board) {
		super(board);
	}

	@Override
	public void init() {
		mover = Lists.newArrayList();
		mover.add(new Kommisar());
		mover.add(new Ermittler());
		mover.add(new PrivatDetektiv());
		mover.add(new Staatsanwalt());

	}

	@Override
	public List<Mover> getMover() {
		return mover;
	}

	@Override
	public Spieler getWinner() {
		return null;
	}

	@Override
	public void showWin(Mover mv) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new GameModule());
		Game game = injector.getInstance(Game.class);
		game.start();

		// new KrimiGame().start();
	}

}
