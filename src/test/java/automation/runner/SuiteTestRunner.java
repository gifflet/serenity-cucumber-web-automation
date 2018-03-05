package automation.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.stereotype.Component;

import automation.listener.RunListenerJunit;

/**
 * Execute suite test runner with Junit
 * 
 */
@Component
public class SuiteTestRunner {

	public Result runWithJunit(final Class<?> clazz) {
		final JUnitCore junit = new JUnitCore();		
		junit.addListener(new RunListenerJunit());
		return junit.run(clazz);
	}
}
