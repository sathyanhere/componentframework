package pages;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import reports.Report;
import utils.WebDriverEventListenerClass;

public class WebPage {
	/**
	 * elementList is a map which contains component and its description, this map is utilized in report generation for writing the details of the 
	 * actions performed of the web elements
	 * 
	 */
	public static HashMap<Object, String> elementList = new HashMap<Object, String>();
	public static String PAGE_URL = "";
	public static EventFiringWebDriver driver =null;
	/*private static String ScreenShotInitial="<a href=\"./screenshot/";
	private static String ScreenShotEnd=".png\"  target=\"_blank\"> SCREEN SHOT </a> \n";*/
	static{
		FirefoxProfile profile = new FirefoxProfile();
	    profile.setPreference("network.http.phishy-userpass-length", 255);
	    profile.setAssumeUntrustedCertificateIssuer(false);
	    driver = new EventFiringWebDriver(new FirefoxDriver(profile));
	    WebDriverEventListener errorListener = new WebDriverEventListenerClass();
	    driver.register(errorListener);
	}
	
	
	
	/**
	 * Constructor method, initialize webdriver instance, initialize page URL
	 * and open the URL in web browser. This constructor is used for the first
	 * page in the application
	 * 
	 * @author Pradeep Sundaram
	 * @param webDriver
	 * @param pageURL
	 */
	public WebPage(WebDriver webDriver, String pageURL) {
		driver =(EventFiringWebDriver)webDriver;
		PAGE_URL = pageURL;
		webDriver.get(PAGE_URL);
	}
	
	

	/**
	 * Constructor initialize the webdriver used for the pages coming after the
	 * first page in application
	 * 
	 * @author Pradeep Sundaram
	 * @param webDriver
	 */
	public WebPage(WebDriver webDriver) {
		driver = (EventFiringWebDriver)webDriver;
		webDriver.get(PAGE_URL);
	}
	
	/**
	 * Constructor, opens the page with passed URL
	 * @param PageURL
	 */
	public WebPage(String PageURL) {
		driver.get(PageURL);
	}
	
	/**
	 * Default Constructor
	 */
	public WebPage() {
	}
	
	/**
	 * This constructor will convert the URL to respective environment configured in testNG XML
	 * 
	 * @author Pradeep Sundaram
	 * @param PageURL
	 * @param env
	 */
	public WebPage(String PageURL, String env) {
		if(PageURL.contains("dev")){
			PageURL=PageURL.replaceAll("dev", env);
		}
		if(PageURL.contains("test")){
			PageURL=PageURL.replaceAll("test", env);
		}
		if(PageURL.contains("stage")){
			PageURL=PageURL.replaceAll("stage", env);
		}
		driver.get(PageURL);
	}

	/**
	 * This method will wait for the element specified for 60 seconds 
	 * @author Pradeep Sundaram
	 * @param by
	 * 
	 */
	public void waitForElementPresent(By by) {
		
		Report.log("Waiting for the element to load " + by.toString());
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	/**
	 * 
	 * This method will wait for the element specifed for specified time
	 * 
	 * @author Pradeep Sundaram
	 * @param by
	 * @param timeToWait
	 * 
	 */
	public void waitForElementPresent(By by, long timeToWait) {
		Report.log("Waiting for the element to load " + by.toString());
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}
	
	
	
	/**
	 * This method will accept the alert thrown in the page and return the control to the page
	 * @author Pradeep Sundaram
	 */
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Report.log("Accepting the alert <BR>");
		driver.switchTo().defaultContent();
		
	}
	
	/**
	 * This method will dismiss the alert and return the control to the page
	 * @author Pradeep Sundaram
	 */
	public void cancelConfirmation() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		driver.switchTo().defaultContent();
	}
	
	/**
	 * verify the presence of passed text
	 * @author Pradeep Sundaram
	 * @param text
	 * @return
	 */
	public boolean isTextPresent(String text) {
		WebElement body = driver.findElement(By.tagName("body"));
		boolean isTextPresent = body.getText().contains(text);
		if (isTextPresent) {
			Report.log("The Text " + text + " is present <BR>");
		} else {
			Report.log("The Text " + text + " is not present <BR>");
		}
		return isTextPresent;
	}
	
	/**
	 * Gets the label of passed WebElement
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @return
	 */
	public String StoreTextPresent(WebElement webElement) {
		return webElement.getText();
	}
	
	/**
	 * wait for text to present in the page
	 * @author Pradeep Sundaram
	 * @param text
	 * @throws Exception 
	 */
	public void waitForTextPresent(String text) throws Exception {
		Assert.assertNotNull(text, "Text can't be null");
		Report.log("waitForTextPresent " + text + "<BR>");
		for (int sec = 1; sec < 60; sec += 1) {
			if ((isTextPresent(text))) {
			}
		}
		Report.log("The passed Text is not present in the page");
		throw new Exception("Text is not available in the page");
	}
	
	/**
	 * wait for text to disappear from the page
	 * @author Pradeep Sundaram
	 * @param text
	 * @throws Exception
	 */
	public void waitForTextToDisappear(String text)throws Exception  {
		Assert.assertNotNull(text, "Text can't be null");
		Report.log("waitForTextToDisappear " + text + "<BR>");
		for (int sec = 0; sec < 60; sec += 1) {
			if (!(isTextPresent(text))) {
				break;
			}
		}
		Report.log("The passed Text does not disappear from the page");
		throw new Exception("The passed Text does not disappear from the page");
	}
	
	/**
	 * verifies the text present in the page
	 * @author Pradeep Sundaram
	 * @param text
	 */
	public void assertTextPresent(String text) {
		Assert.assertNotNull(text, "Text can't be null");
		Report.log("Assert Text Present ");
		Assert.assertTrue(isTextPresent(text));
	}
	
	/**
	 * verifies the Text not present in the page
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 */
	public void assertTextNotPresent(String text) {
		Assert.assertNotNull(text, "Text can't be null");
		Report.log("Assert Text not Present ");
		Assert.assertFalse(isTextPresent(text));
	}
	
}