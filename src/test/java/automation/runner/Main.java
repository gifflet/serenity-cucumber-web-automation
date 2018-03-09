package automation.runner;

import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import automation.setup.WebTest;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/setup-spring.xml")
public class Main {

	@Autowired
	SuiteTestRunner testRunner;
	
	@Test
	public void run() {
		testRunner = new SuiteTestRunner();
		Result result = testRunner.runWithJunit(WebTest.class);
		if (result.getFailureCount() > 0) {
			System.out.println("================== FAILURES ====================");
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.getException());
			}
			System.out.println("================================================");
		}
	}
}