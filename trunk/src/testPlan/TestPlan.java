package testPlan;

import static org.testng.Assert.fail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.WebPage;
import reports.Report;
import utils.EventsUtil;
import utils.KeyEvents;
import utils.WindowEvents;
import browser.Browser;
import controls.Button;
import controls.CheckBox;
import controls.DateControl;
import controls.Label;
import controls.Link;
import controls.SelectBox;
import controls.TextArea;
import controls.TextField;

public class TestPlan {

	private Properties properties = new Properties();
	private KeyEvents keyEvents;
	private WindowEvents windowEvents;
	private StringBuffer verificationErrors = new StringBuffer();
	
	/**
	 * This method will clear the screen shot files of previous run
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException 
	 */

	
	
	@Parameters({"screenshotRequired","retryCount","IEDriverPath","ChromeDriverPath"})
	@BeforeSuite(groups = "TestPlan")
	public void setUp(@Optional("true") String screenshotRequired,
			@Optional("5") String retryCount, @Optional("D:\\selenium drivers\\IEDriverServer.exe") String IEDriverPath,
			@Optional("D:\\selenium drivers\\chromedriver.exe") String ChromeDriverPath) throws IOException {
		Report.log("Test Execution starts");
		Browser.IEDriverPath=IEDriverPath;
		Browser.ChromeDriverPath=ChromeDriverPath;
		WebPage.screenshotRequired=Boolean.parseBoolean(screenshotRequired);
		WebPage.retryCount=Integer.parseInt(retryCount);
		/*WebPage.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/
		File file = new File(".//src//ReportData.txt");
		RandomAccessFile raf=new RandomAccessFile(file,"r");
		String previousExecutionTime=raf.readLine();
		if(!"".equals(previousExecutionTime) && previousExecutionTime !=null ){
			File directory = new File(".");
			String oldPath = directory.getCanonicalPath() + "\\test-output\\";
			File oldfile = new File(oldPath);
			String newName=oldfile+previousExecutionTime;
			File newFolderName=new File(newName);
			oldfile.renameTo(newFolderName);
		}
	}

	/**
	 * This method will assign the name of the property file where the data is stored
	 * 
	 * @author Pradeep Sundaram
	 * @param reportFilePath
	 * @throws Exception
	 */
	@Parameters(value = "dataFile")
	@BeforeTest(groups = "TestPlan")
	public void setPropertyFilePath(@Optional("data.properties") String dataFile) throws Exception {
		System.out.println("setting property file path");
		File directory = new File (".");
		properties.load(new FileInputStream(directory.getCanonicalPath()+"\\src\\properties\\"+dataFile));
		
	}
	/**
	 * This method will close the driver instance and open the report in default browser
	 * 
	 * @author Pradeep Sundaram
	 * @throws Exception
	 */
	@AfterTest(groups = "TestPlan")
	public void tearDown() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		String exeTime = dateFormat.format(date);
		File file = new File(".//src//ReportData.txt");
		Writer output = new BufferedWriter(new FileWriter(file));
		output.write(exeTime);
		output.close();
		File directory = new File(".");
		String reportPath = directory.getCanonicalPath() + "\\test-output\\index.html";
		String verificationErrorString = verificationErrors.toString();
		System.out.println("Test Execution stops and Report is generated in the location \""+reportPath+"\"");
		if (!"".equals(verificationErrorString)) {
		      Report.log(verificationErrorString);
		      fail(verificationErrorString);
		    }
	}
	/**
	 * presses esc key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void pressEscKey(){
		keyEvents=new EventsUtil();
		keyEvents.pressEscKey();
	}
	
	/**
	 * 
	 * presses down arrow key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void pressDownKey(){
		keyEvents=new EventsUtil();
		keyEvents.pressDownKey();
	}
	
	
	/**
	 * presses down arrow key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void releaseDownKey(){
		keyEvents=new EventsUtil();
		keyEvents.releaseDownKey();
	}
	
	/**
	 * presses shift key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void pressShiftKey(){
		keyEvents=new EventsUtil();
		keyEvents.pressShiftKey();
	}
	
	/**
	 * Presses control key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void pressCtrlKey(){
		keyEvents=new EventsUtil();
		keyEvents.pressCtrlKey();
	}
	
	/**
	 * releases shift key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void releaseShiftKey(){
		keyEvents=new EventsUtil();
		keyEvents.releaseShiftKey();
	}
	
	/**
	 * releases control key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void releaseCtrlKey(){
		keyEvents=new EventsUtil();
		keyEvents.releaseCtrlKey();
	}
	
	/**
	 * This method will press backspace key
	 */
	public void pressBackSpace(){
		keyEvents=new EventsUtil();
		keyEvents.pressBackSpace();
	}
	
	
	/**
	 * This method will press TAB Key
	 * 
	 * Use this method when the frame of popup is not identified
	 * 
	 * @author Pradeep Sundaram
	 */
	public void pressTabKey() {
		keyEvents=new EventsUtil();
		keyEvents.pressTabKey();	
	}
	
	/**
	 * This method will press SHIFT+TAB keys to the specified no. of times
	 * 
	 * @author Pradeep Sundaram 
	 * @param howManyTimes
	 */
	public void pressShiftTabKey(int howManyTimes){
		keyEvents=new EventsUtil();
		keyEvents.pressShiftTabKey(howManyTimes);	
	}
	
	/**
	 * This method will press TAB key for the passed no. of times
	 * 
	 * @author Pradeep Sundaram
	 * @param howManyTimes
	 */
	public void pressTabKey(int howManyTimes) {
		keyEvents = new EventsUtil();
		keyEvents.pressTabKey(howManyTimes);
	}
	
	/**
	 * This method will press ENTER key
	 * 
	 * @author Pradeep Sundaram
	 */
	public void pressEnterKey(){
		keyEvents=new EventsUtil();
		keyEvents.pressEnterKey();	
	}
	
	
	/**
	 * This method will type the passed string in the text field in frames and other components not identified by selenium IDE
	 * 
	 * @author Pradeep Sundaram 
	 * @param text
	 */
	public void type(String text){
		keyEvents=new EventsUtil();
		keyEvents.type(text);	
		
	}
	
	
	/**
	 * This method will press SPACE bar
	 * 
	 * @author Pradeep Sundaram
	 */
	public void pressSpaceBar() {
		keyEvents=new EventsUtil();
		keyEvents.pressSpaceBar();	
	}
	
	/**
	 * Normal assert true method
	 * 
	 * @author Pradeep Sundaram
	 * @param bool
	 */
	public void assertTrue(boolean bool){
		Report.log("Asserting True ");
		Assert.assertTrue(bool);
	}

	/**
	 * Normal Verify true method
	 * 
	 * @author PSubramani33
	 * @param bool
	 */
	public void verifyTrue(boolean bool) {
		Report.log("Verifying True");
		try {
			Assert.assertTrue(bool);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	/**
	 * Normal Verify false method
	 * 
	 * @author Pradeep Sundaram 
	 * @param bool
	 */
	public void verifyFalse(boolean bool){
		Report.log("Verifying False ");
		try {
			Assert.assertFalse(bool);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	
	/**
	 * Normal assert false method
	 * 
	 * @author Pradeep Sundaram 
	 * @param bool
	 */
	public void assertFalse(boolean bool){
		Report.log("Asserting False ");
		Assert.assertFalse(bool);
	}
	
	/**
	 * This method will compare two strings
	 * 
	 * @author Pradeep Sundaram
	 * @param expected
	 * @param actual
	 */
	public void assertEquals(String expected, String actual){
		Report.log("Comparing two strings "+ expected +" and "+actual);
		Assert.assertEquals(expected, actual);
		Report.log(" Comparision result passed");
	}
	
	/**
	 * This method will verify two strings
	 * 
	 * @author Pradeep Sundaram
	 * @param expected
	 * @param actual
	 */
	public void verifyEquals(String expected, String actual){
		Report.log("Comparing two strings "+ expected +" and "+actual);
		try {
			Assert.assertEquals(expected, actual);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	/**
	 * This method will compare two integers
	 * 
	 * @param expected
	 * @param actual
	 */
	public void assertEquals(int expected, int actual){
		Report.log("Comparing two integers "+ expected +" and "+actual);
		Assert.assertEquals(expected, actual);
		Report.log(" Comparision result passed ");
	}
	
	/**
	 * This method will verify two integers
	 * 
	 * @param expected
	 * @param actual
	 */
	public void verifyEquals(int expected, int actual){
		Report.log("Comparing two integers "+ expected +" and "+actual);
		try {
			Assert.assertEquals(expected, actual);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	/**
	 * This element will place the mouse over the passed webelement
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws AWTException
	 *//*
		public void mouseOver(WebElement webElement) {
			mouseEvents = new EventsUtil();
			mouseEvents.mouseOver(webElement);
		}*/
	
	
	/**
	 * This method will select the frame name passed as argument
	 * 
	 * @author Pradeep Sundaram
	 * @param frameName
	 */
	public void selectFrame(WebDriver driver, String frameName){
		windowEvents=new EventsUtil();
		windowEvents.selectFrame(driver, frameName);
	}
	
	/**
	 * This method will select the given window
	 * 
	 * @author Pradeep Sundaram
	 * @param windowName
	 */
	public void selectWindow(WebDriver driver,String windowName){
		windowEvents=new EventsUtil();
		windowEvents.selectWindow(driver, windowName);
	}
	
	
	/**
	 * This method will switch the control to the main page
	 * 
	 * @author Pradeep Sundaram
	 * @param windowName
	 */
	public void switchToMainPage(WebDriver driver){
		windowEvents=new EventsUtil();
		windowEvents.switchToMainPage(driver);
	}
	
	/**
	 * This method will wait for TextField for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextField(TextField tf,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(tf));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(tf.getBy()));
	}
	
	/**
	 * This method will wait for TextArea for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextArea(TextArea ta,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(ta));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(ta.getBy()));
	}
	
	/**
	 * This method will wait for Button for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForButton(Button button,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(button));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(button.getBy()));
	}
	
	/**
	 * This method will wait for Label for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLabel(Label label,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(label));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(label.getBy()));
	}
	
	/**
	 * This method will wait for Check Box for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForCheckBox(CheckBox check,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(check));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(check.getBy()));
	}
	
	/**
	 * This method will wait for Date Control for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForDateControl(DateControl date,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(date));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(date.getBy()));
	}
	
	
	/**
	 * This method will wait for Link for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLink(Link link,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(link));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(link.getBy()));
	}
	
	
	/**
	 * This method will wait for SelectBox for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForSelect(SelectBox select,WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(select));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(select.getBy()));
	}
	
	
	/**
	 * This method will wait for TextField for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextField(TextField tf,Long timeToWait, WebDriver driver){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(tf));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(tf.getBy()));
	}
	
	/**
	 * This method will wait for TextArea for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextArea(TextArea ta,Long timeToWait, WebDriver driver) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(ta));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(ta.getBy()));
	}
	
	/**
	 * This method will wait for Button for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForButton(Button button,Long timeToWait, WebDriver driver) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(button));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(button.getBy()));
	}
	
	/**
	 * This method will wait for Label for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLabel(Label label,Long timeToWait, WebDriver driver) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(label));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(label.getBy()));
	}
	
	/**
	 * This method will wait for Check Box for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForCheckBox(CheckBox check,Long timeToWait, WebDriver driver) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(check));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(check.getBy()));
	}
	
	/**
	 * This method will wait for Date Control for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForDateControl(DateControl date,Long timeToWait, WebDriver driver) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(date));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(date.getBy()));
	}
	
	
	/**
	 * This method will wait for Link for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLink(Link link,Long timeToWait, WebDriver driver) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(link));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(link.getBy()));
	}
	
	
	/**
	 * This method will wait for SelectBox for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForSelect(SelectBox select,Long timeToWait, WebDriver driver) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(select));
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(select.getBy()));
	}
	
	
	/**
	 * Triggers a JS click 
	 */
	public void jsClick(WebDriver driver, WebElement element){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
		Report.log("clicking the element \'"+ WebPage.elementList.get(element));
	}
	
	
}