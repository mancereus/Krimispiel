package de.db12.krimispiel;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.util.Types;

import de.db12.krimispiel.model.Game;
import de.db12.krimispiel.model.KrimiGame;
import de.db12.krimispiel.model.board.Board;
import de.db12.krimispiel.model.board.LineBoard;
import de.db12.krimispiel.model.board.PyramidBoard;
import de.db12.krimispiel.model.mover.Mover;

public class GameModule extends AbstractModule {

	@Override
	protected void configure() {
		bindConstant().annotatedWith(Names.named("QUEUE_SIZE")).to(15);
		bind(Game.class).to(KrimiGame.class);
		bind(Board.class).to(PyramidBoard.class);
	}


}
