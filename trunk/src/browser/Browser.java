package browser;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utils.WebDriverEventListenerClass;

public class Browser {

	public static EventFiringWebDriver getInstance(String browerType) {
		WebDriverEventListenerClass eventListener = new WebDriverEventListenerClass();
		
		if (browerType.equals("firefox")) {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.http.phishy-userpass-length", 255);
			profile.setAssumeUntrustedCertificateIssuer(false);
			EventFiringWebDriver driver = new EventFiringWebDriver(new FirefoxDriver(profile));
			driver.register(eventListener);
			return driver;
		} 
		else if (browerType.equals("ie")) {
			System.setProperty("webdriver.ie.driver","D:\\selenium drivers\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			EventFiringWebDriver driver = new EventFiringWebDriver(new InternetExplorerDriver(ieCapabilities));
			driver.register(eventListener);
			return driver;
		}
		return null;
	}
}
