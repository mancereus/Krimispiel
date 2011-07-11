package de.db12.krimispiel;

import java.lang.reflect.InvocationTargetException;

import org.jukito.JukitoRunner;
import org.junit.runners.model.InitializationError;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public abstract class GuiceTestRunner extends JukitoRunner {
	private Injector injector;

	public GuiceTestRunner(final Class<?> classToRun, Module... modules) throws InitializationError, InvocationTargetException, InstantiationException, IllegalAccessException {
		super(classToRun);
		injector = Guice.createInjector(modules);
	}

	@Override
	public Object createTest() {
		return injector.getInstance(getTestClass().getJavaClass());
	}
	// ...
}