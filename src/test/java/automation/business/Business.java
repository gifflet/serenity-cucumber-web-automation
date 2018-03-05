package automation.business;

import automation.pages.Page;
import net.thucydides.core.annotations.Step;

public class Business {

	Page page;
	
	@Step
	public void pesquisar(String value) {
		page.getDriver().get("https://www.google.com");
		page.getSearchBar().sendKeys(value);
	}
	
	@Step
	public void pesquisarFalha(String value) {
		page.getDriver().get("https://www.google.com");
		page.getSearchBarWrong().sendKeys(value);
	}
}
