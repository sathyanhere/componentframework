package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	public static EventFiringWebDriver driver;
	public static String PROXY;
	
	public static void setPROXY(String proxy) {
		PROXY = proxy;
	}

	public static void setProxyAndProfile() throws FileNotFoundException, IOException{
		File directory = new File (".");
		Properties properties = new Properties();
		properties.load(new FileInputStream(directory.getCanonicalPath()+"\\src\\properties\\data.properties"));
		String proxy1=properties.getProperty("proxy");
		String port=properties.getProperty("port");
		String reqString=proxy1+":"+port;
		WebPage.setPROXY(reqString);
		
		Proxy proxy = new Proxy();
		System.out.println("proxy string is "+PROXY);
		proxy.setHttpProxy(PROXY);
		proxy.setFtpProxy(PROXY);
		proxy.setSslProxy(PROXY);
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(CapabilityType.PROXY, proxy);
		
		FirefoxProfile profile = new FirefoxProfile();
	    profile.setPreference("network.http.phishy-userpass-length", 255);
	    profile.setAssumeUntrustedCertificateIssuer(false);
	    cap.setCapability(FirefoxDriver.PROFILE, profile);
	    driver = new EventFiringWebDriver(new FirefoxDriver(cap));
	    
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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public WebPage(WebDriver webDriver, String pageURL) {
		try{
			setProxyAndProfile();	
		}
		catch(FileNotFoundException FNNE){
			FNNE.printStackTrace();
		}
		catch(IOException IOE){
			IOE.printStackTrace();
		} 
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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public WebPage(WebDriver webDriver)  {
		try{
			setProxyAndProfile();	
		}
		catch(FileNotFoundException FNNE){
			FNNE.printStackTrace();
		}
		catch(IOException IOE){
			IOE.printStackTrace();
		} 
		driver = (EventFiringWebDriver)webDriver;
		webDriver.get(PAGE_URL);
	}
	
	/**
	 * Constructor, opens the page with passed URL
	 * @param PageURL
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public WebPage(String PageURL) {
		try{
			setProxyAndProfile();	
		}
		catch(FileNotFoundException FNNE){
			FNNE.printStackTrace();
		}
		catch(IOException IOE){
			IOE.printStackTrace();
		} 
		driver.get(PageURL);
	}
	
	/**
	 * Default Constructor
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public WebPage() {
		try{
			setProxyAndProfile();	
		}
		catch(FileNotFoundException FNNE){
			FNNE.printStackTrace();
		}
		catch(IOException IOE){
			IOE.printStackTrace();
		} 
	}
	
	/**
	 * This constructor will convert the URL to respective environment configured in testNG XML
	 * 
	 * @author Pradeep Sundaram
	 * @param PageURL
	 * @param env
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public WebPage(String PageURL, String env) {
		try{
			setProxyAndProfile();	
		}
		catch(FileNotFoundException FNNE){
			FNNE.printStackTrace();
		}
		catch(IOException IOE){
			IOE.printStackTrace();
		} 
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
		Report.log("Waiting for the element to load " + by.toString()+"<BR>");
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
		Report.log("Waiting for the element to load " + by.toString()+"<BR>");
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
	
	
	
	public void MouseHoverByJavaScript(WebElement targetElement) {
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"click\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript, targetElement);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void  jsClick(WebElement targetElement) {
		final String jsCode = "try { " +
				"alert(arguments[0]);" +
				"if(arguments[0].href && arguments[0].target){ " +
				"alert(\" if \");" 
				+ " window.open(arguments[0].href,arguments[0].target)"
				+ " } else { arguments[0].click(); alert(\" else \"); }} catch(err) {alert(\" catch \"); }";
		((JavascriptExecutor) driver).executeScript(jsCode, targetElement);
//		return jsCode;
	}
	      
	
	public void closePopUPWindow(){
		String mainWinHander = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String handle : handles)
		{
		   if(!mainWinHander.equals(handle))
		    {
		        WebDriver popup = driver.switchTo().window(handle);
		        popup.close();
		    }
		}
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