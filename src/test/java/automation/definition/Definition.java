package automation.definition;

import automation.business.Business;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class Definition {

	@Steps
	Business business;
	String arg = null;
	
	@Given("^test iniciated \"([^\"]*)\"$")
	public void test_iniciated(String arg1) throws Throwable {
		arg = arg1;
	    System.out.println("test initiated: " + arg);
	    business.pesquisar(arg1);
	}
	
	@Given("^test iniciated 2 \"([^\"]*)\"$")
	public void test_iniciated2(String arg1) throws Throwable {
		arg = arg1;
		System.out.println("test initiated: " + arg);
		business.pesquisarFalha(arg1);
	}

	@Then("^test finished$")
	public void test_finished() throws Throwable {
	    System.out.println(arg + " finished");
	}
}
