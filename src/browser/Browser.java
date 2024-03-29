package browser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import pages.WebPage;

import utils.WebDriverEventListenerClass;

public class Browser {
	public static String IEDriverPath=null;
	public static String ChromeDriverPath=null;
	public static String firefoxPath=null;
	
	/**
	 * This method will return the EventFiringWebDriver's Instance which can be stored in WebDriver's reference
	 * <BR><BR>
	 * pass "firefox" to get firefox browser
	 * <BR><BR>
	 * pass "ie" for Internet Explorer browser
	 * <BR><BR>
	 * pass "chrome" to get Chrome browser
	 * 
	 * @author Pradeep Sundaram
	 * @param browerType
	 * @return
	 */
	public static EventFiringWebDriver getInstance(String browerType) {
		WebDriverEventListenerClass eventListener = new WebDriverEventListenerClass();
		if (browerType.equals("firefox")) {
			System.setProperty("webdriver.firefox.bin",WebPage.firefoxPath);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.http.phishy-userpass-length", 255);
			profile.setAssumeUntrustedCertificateIssuer(false);
			EventFiringWebDriver driver = new EventFiringWebDriver(new FirefoxDriver(profile));
			driver.register(eventListener);
			return driver;
		} 
		else if (browerType.equals("ie")) {
			System.out.println("driver path is "+IEDriverPath);
			System.setProperty("webdriver.ie.driver",IEDriverPath);
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability("ignore-certificate",true);
			ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			EventFiringWebDriver driver = new EventFiringWebDriver(new InternetExplorerDriver(ieCapabilities));
			driver.register(eventListener);
			return driver;
		}
		else if (browerType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
			DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
			chromeCapabilities.setCapability("ignore-certificate",true);
			chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver(chromeCapabilities));
			driver.register(eventListener);
			return driver;
		}
		return null;
	}
}
