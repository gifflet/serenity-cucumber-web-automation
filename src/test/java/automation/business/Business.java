package automation.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import automation.pages.Page;
import net.thucydides.core.annotations.Step;

public class Business {

	Page page;
	public static final long DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT = 5;
	
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
	
	public void abrirPagina(String value) {
		page.getDriver().get(value);
	}
	
	public void pesquisarPor(String value) {
		final FluentWait<WebDriver> fluent = this.createInstanceFluentWait(page.getDriver(), 10);

		final WebElement elementWaiting = fluent.until(ExpectedConditions.visibilityOf(page.getSearchBar()));
		
		elementWaiting.sendKeys(value);
		page.getSearchBar().submit();
	}
	
	private FluentWait<WebDriver> createInstanceFluentWait(final WebDriver driver, final int timeout) {
		return new FluentWait<WebDriver>(driver)
				.withTimeout(timeout, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_SECONDS_FREQUENCY_FIND_ELEMENT, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
	}
}
