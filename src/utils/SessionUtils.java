package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionUtils {

	private SessionUtils() {
		
	}
	/**
	 * This method will return a new driver instance (a new browser)
	 * 
	 * @author Pradeep Sundaram
	 * @return WebDriver
	 */
	public static WebDriver getNewFireFox() {
		return new FirefoxDriver();
	}

}