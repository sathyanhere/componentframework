package testPlan;

import java.awt.AWTException;
import java.awt.Robot;
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
import java.util.concurrent.TimeUnit;

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
import utils.MouseEvents;
import utils.WindowEvents;
import controls.Button;
import controls.CheckBox;
import controls.DateControl;
import controls.Label;
import controls.Link;
import controls.SelectBox;
import controls.TextArea;
import controls.TextField;

public class TestPlan {

	public Properties properties = new Properties();
	public Robot robot;
	public KeyEvents keyEvents;
	public MouseEvents mouseEvents;
	public WindowEvents windowEvents;
	
	
	/**
	 * This method will clear the screen shot files of previous run
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException 
	 */
	
	@BeforeSuite(groups = "TestPlan")
	public void setUp() throws IOException {
		System.out.println("Test Execution starts");
		WebPage.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
		
		
		/*File directory = new File (".");
		String path=directory.getCanonicalPath()+"\\test-output\\screenshot\\";
		File f = new File(path);
		File files[] = f.listFiles();
		if(files!=null){
			for (int index = 0; index < files.length; index++) {
				files[index].delete();
			}	
		}*/
		
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
		WebPage.driver.quit();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		String exeTime = dateFormat.format(date);
		File file = new File(".//src//ReportData.txt");
		Writer output = new BufferedWriter(new FileWriter(file));
		System.out.println("before writing into the file");
		output.write(exeTime);
		output.close();
		File directory = new File(".");
		String reportPath = directory.getCanonicalPath() + "\\test-output\\index.html";
		System.out.println("Test Execution stops and Report is generated in the location \""+reportPath+"\"");
	}
	
	public void pressEscKey()throws AWTException{
		/*robot=new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Report.log("Pressing Esc key <BR>");*/
		keyEvents=new EventsUtil();
		keyEvents.pressEscKey();
	}
	
	/**
	 * This method will press backspace key
	 * @throws AWTException
	 */
	public void pressBackSpace()throws AWTException{
		/*robot=new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Report.log("Pressing back space key <BR>");*/
		keyEvents=new EventsUtil();
		keyEvents.pressBackSpace();
		
	}
	
	
	/**
	 * This method will press TAB Key
	 * 
	 * Use this method when the frame of popup is not identified
	 * 
	 * @author Pradeep Sundaram
	 * @throws AWTException
	 */
	public void pressTabKey() throws AWTException{
		/*robot=new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Report.log("Pressing TAB key <BR>");*/
		keyEvents=new EventsUtil();
		keyEvents.pressTabKey();
	}
	
	/**
	 * This method will press SHIFT+TAB keys to the specified no. of times
	 * 
	 * @author Pradeep Sundaram 
	 * @param howManyTimes
	 * @throws AWTException
	 */
	public void pressShiftTabKey(int howManyTimes) throws AWTException{
		/*robot=new Robot();
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.delay(500);
		this.pressTabKey(howManyTimes);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		Report.log("Pressing Shift+TAB keys "+howManyTimes+" times <BR>");*/
		
		keyEvents=new EventsUtil();
		keyEvents.pressShiftTabKey(howManyTimes);
	}
	
	/**
	 * This method will press TAB key for the passed no. of times
	 * 
	 * @author Pradeep Sundaram
	 * @param howManyTimes
	 * @throws AWTException
	 */
	public void pressTabKey(int howManyTimes) throws AWTException{
		/*robot=new Robot();
		for(int i=0;i<howManyTimes;i++){
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
		}
		Report.log("Pressing TAB key for "+howManyTimes +" times <BR>");*/
		keyEvents=new EventsUtil();
		keyEvents.pressTabKey(howManyTimes);
	}
	
	/**
	 * This method will press ENTER key
	 * 
	 * @author Pradeep Sundaram
	 * @throws AWTException
	 */
	public void pressEnterKey()throws AWTException{
		/*robot=new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Report.log("Pressing ENTER key <BR>");*/
		keyEvents=new EventsUtil();
		keyEvents.pressEnterKey();
	}
	
	
	/**
	 * This method will type the passed string in the text field in frames and other components not identified by selenium IDE
	 * 
	 * @author Pradeep Sundaram 
	 * @param text
	 * @throws AWTException
	 */
	public void type(String text) throws AWTException{
		/*robot=new Robot();
		robot.delay(500);
		String[] textArray =text.split("");
		for (int i=1;i<textArray.length;i++){
			robot.delay(500);
			robot.keyPress(TextUtil.getAsciiValue(textArray[i]));
			Report.log("Entering "+textArray[i]+"<BR>");
		}*/
		keyEvents=new EventsUtil();
		keyEvents.type(text);
	}
	
	
	/**
	 * This method will press SPACE bar
	 * 
	 * @author Pradeep Sundaram
	 * @throws AWTException
	 */
	public void pressSpaceBar() throws AWTException{
		/*robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_SPACE);*/
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
		Assert.assertTrue(bool);
	}
	
	
	/**
	 * Normal assert false method
	 * 
	 * @author Pradeep Sundaram 
	 * @param bool
	 */
	public void assertFalse(boolean bool){
		Report.log("Asserting False <BR>");
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
		Report.log(" Comparision result passed <BR>");
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
		Report.log(" Comparision result passed <BR>");
	}
	
	/**
	 * This element will place the mouse over the passed webelement
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws AWTException
	 */
		public void mouseOver(WebElement webElement) {
			/*Actions builder=new Actions(WebPage.driver);
	        builder.moveToElement(webElement).perform();
	        Report.log("Moving mouse over "+WebPage.elementList.get(webElement)+"<BR>");*/
			mouseEvents = new EventsUtil();
			mouseEvents.mouseOver(webElement);
		}
	
	
	/**
	 * This method will select the frame name passed as argument
	 * 
	 * @author Pradeep Sundaram
	 * @param frameName
	 */
	public void selectFrame(String frameName){
		/*WebPage.driver.switchTo().frame(frameName);*/
		windowEvents=new EventsUtil();
		windowEvents.selectFrame(frameName);
	}
	
	/**
	 * This method will select the given window
	 * 
	 * @author Pradeep Sundaram
	 * @param windowName
	 */
	public void selectWindow(String windowName){
//		WebPage.driver.switchTo().window(windowName);
		windowEvents=new EventsUtil();
		windowEvents.selectWindow(windowName);
	}
	
	
	/**
	 * This method will wait for TextField for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextField(TextField tf){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(tf));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(tf.getBy()));
	}
	
	/**
	 * This method will wait for TextArea for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextArea(TextArea ta) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(ta));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(ta.getBy()));
	}
	
	/**
	 * This method will wait for Button for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForButton(Button button) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(button));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(button.getBy()));
	}
	
	/**
	 * This method will wait for Label for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLabel(Label label) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(label));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(label.getBy()));
	}
	
	/**
	 * This method will wait for Check Box for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForCheckBox(CheckBox check) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(check));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(check.getBy()));
	}
	
	/**
	 * This method will wait for Date Control for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForDateControl(DateControl date) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(date));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(date.getBy()));
	}
	
	
	/**
	 * This method will wait for Link for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLink(Link link) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(link));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(link.getBy()));
	}
	
	
	/**
	 * This method will wait for SelectBox for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForSelect(SelectBox select) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(select));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(select.getBy()));
	}
	
	
	/**
	 * This method will wait for TextField for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextField(TextField tf,Long timeToWait){
		Report.log("Waiting for the element to load " + WebPage.elementList.get(tf));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(tf.getBy()));
	}
	
	/**
	 * This method will wait for TextArea for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForTextArea(TextArea ta,Long timeToWait) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(ta));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(ta.getBy()));
	}
	
	/**
	 * This method will wait for Button for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForButton(Button button,Long timeToWait) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(button));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(button.getBy()));
	}
	
	/**
	 * This method will wait for Label for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLabel(Label label,Long timeToWait) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(label));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(label.getBy()));
	}
	
	/**
	 * This method will wait for Check Box for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForCheckBox(CheckBox check,Long timeToWait) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(check));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(check.getBy()));
	}
	
	/**
	 * This method will wait for Date Control for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForDateControl(DateControl date,Long timeToWait) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(date));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(date.getBy()));
	}
	
	
	/**
	 * This method will wait for Link for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForLink(Link link,Long timeToWait) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(link));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(link.getBy()));
	}
	
	
	/**
	 * This method will wait for SelectBox for 60 seconds 
	 * @author Pradeep Sundaram
	 */
	public void waitForSelect(SelectBox select,Long timeToWait) {
		Report.log("Waiting for the element to load " + WebPage.elementList.get(select));
		WebDriverWait wait = new WebDriverWait(WebPage.driver, timeToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(select.getBy()));
	}
	
}