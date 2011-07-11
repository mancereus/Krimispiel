package de.db12.krimispiel;

import java.lang.reflect.InvocationTargetException;

import org.junit.runners.model.InitializationError;

public class GameTestRunner extends GuiceTestRunner {

	public GameTestRunner(Class<?> classToRun) throws InitializationError, InvocationTargetException, InstantiationException, IllegalAccessException {
		super(classToRun, new GameModule());
	}

}