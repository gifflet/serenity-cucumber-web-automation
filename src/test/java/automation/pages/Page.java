package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class Page extends PageObject {
	
	@FindBy(name="q")
	WebElement searchBar;
	
	@FindBy(name="not_exist")
	WebElement searchBarWrong;

	public WebElement getSearchBar() {
		return searchBar;
	}
	
	public WebElement getSearchBarWrong() {
		return searchBarWrong;
	}
	
	public WebDriver getDriver() {
		return ThucydidesWebDriverSupport.getDriver();
	}
}
