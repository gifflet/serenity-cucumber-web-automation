package automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class IEDriver implements DriverSource {

	@Override
	public WebDriver newDriver() {
		System.out.println("Creating Internet Explorer Custom Driver");
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		@SuppressWarnings("deprecation")
		WebDriver driver = new InternetExplorerDriver(capabilities);
		return driver;
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

}
