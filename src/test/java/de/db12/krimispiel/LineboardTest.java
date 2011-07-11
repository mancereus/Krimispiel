package de.db12.krimispiel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.google.inject.Inject;

import de.db12.krimispiel.model.Game;

@RunWith(GameTestRunner.class)
public class LineboardTest {

	private static final Logger log = LoggerFactory.getLogger(LineboardTest.class);

	@Rule
	public MethodRule benchmarkRun = new BenchmarkRule();

	@Inject Game game;
	
	@Test
	public void test() {
		game.start();
	}

}
