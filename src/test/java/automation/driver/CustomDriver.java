package automation.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.PropertyException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import net.thucydides.core.webdriver.DriverSource;

public class CustomDriver implements DriverSource {

	@Override
	public WebDriver newDriver() {
		WebDriver appiumDriver;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		try {
			String platformName = PropertiesSerenityUtil
					.getProperty("webdriver.provided.automation.driver.CustomDriver.platformName");

			if (platformName.equalsIgnoreCase("ANDROID")) {
				capabilities.setCapability("appActivity", PropertiesSerenityUtil
						.getProperty("webdriver.provided.automation.driver.CustomDriver.appActivity"));
				capabilities.setCapability("appWaitActivity", PropertiesSerenityUtil
						.getProperty("webdriver.provided.automation.driver.CustomDriver.appWaitActivity"));
				capabilities.setCapability("appPackage", PropertiesSerenityUtil
						.getProperty("webdriver.provided.automation.driver.CustomDriver.appPackage"));

			}
			File app = new File(
					PropertiesSerenityUtil.getProperty("webdriver.provided.automation.driver.CustomDriver.app"));
			if (!app.exists())
				throw new RuntimeException(String.format("%s doesn't exist", PropertiesSerenityUtil
						.getProperty("webdriver.provided.automation.driver.CustomDriver.app")));
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("noReset", Boolean.parseBoolean(PropertiesSerenityUtil
					.getProperty("webdriver.provided.automation.driver.CustomDriver.noReset")));
			capabilities.setCapability("deviceName", PropertiesSerenityUtil
					.getProperty("webdriver.provided.automation.driver.CustomDriver.deviceName"));
			capabilities.setCapability("platformVersion", PropertiesSerenityUtil
					.getProperty("webdriver.provided.automation.driver.CustomDriver.platformVersion"));
			capabilities.setCapability("platformName", PropertiesSerenityUtil
					.getProperty("webdriver.provided.automation.driver.CustomDriver.platformName"));
			String host = PropertiesSerenityUtil
					.getProperty("webdriver.provided.automation.driver.CustomDriver.host");

			if (platformName.equalsIgnoreCase("ANDROID")) {
				AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(new URL(host),
						capabilities);
				appiumDriver = (AppiumDriver) androidDriver;
				appiumDriver.manage().timeouts().implicitlyWait(
						Long.parseLong(PropertiesSerenityUtil
								.getProperty("webdriver.provided.automation.driver.CustomDriver.implicityWait")),
						TimeUnit.SECONDS);
				return androidDriver;
			} else {
				IOSDriver<IOSElement> iosDriver = new IOSDriver<IOSElement>(new URL(host), capabilities);
				appiumDriver = (AppiumDriver) iosDriver;
				appiumDriver.manage().timeouts().implicitlyWait(
						Long.parseLong(PropertiesSerenityUtil
								.getProperty("webdriver.provided.automation.driver.CustomDriver.implicityWait")),
						TimeUnit.SECONDS);
				return iosDriver;
			}

		} catch (PropertyException e1) {
			e1.printStackTrace();
			throw new RuntimeException("Some required property was not found", e1);
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
			throw new RuntimeException("URL exception", e2);
		}
	}

	@Override
	public boolean takesScreenshots() {
		return false;
	}

}
