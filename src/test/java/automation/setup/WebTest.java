package automation.setup;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * Unit test for simple App.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(glue="automation.definition", features="src/test/resources")
public class WebTest {
	
	
}
