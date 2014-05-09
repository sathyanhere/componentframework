package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pages.WebPage;
import reports.Report;
import exception.CFException;


public class Events implements MouseEvents{
	private WebDriver driver;
	public Actions action;
	public Events(WebDriver webDriver){
		driver=webDriver;
	}
	
	private static String ScreenShotInitial="<a href=\"./screenshot/";
	private static String ScreenShotEnd=".png\"  target=\"_blank\"> SCREEN SHOT </a> \n";
	private static Integer counter=1;
	
	/**
	 * This method will click in the webElement passed as argument
	 *  
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws CFException 
	 */
	public void click(WebElement webElement) throws CFException  {
		webElement.click();
		write("<b>Clicking the '"+WebPage.elementList.get(webElement)+"'");
	}
	
	/**
	 * This method will double click on the webelement passed as argument
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws CFException 
	 */
	@Override
	public void doubleClick(WebElement webElement) throws CFException {
		try{
			action = new Actions(driver);
			action.doubleClick(webElement).perform();
			Thread.sleep(500);	
		}
		catch(InterruptedException e){
			
		}
		write("<b>Double clicking the element "+WebPage.elementList.get(webElement));
	}
	/**
	 * This method will scroll down if positive value is passed and scroll up on negative input.
	 * The input max value is 100 + or -
	 * 
	 * @author Pradeep Sundaram
	 * @param no. of rotations
	 * 
	 */
	public void scrollDown(int rotations){
		/*JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy("+xposition+","+yposition+")", "");*/
		try{
			Robot robot=new Robot();
			robot.setAutoDelay(1000);
			robot.mouseWheel(rotations);	
		}
		catch(AWTException ie){
			Report.log("AWT Exception");
			ie.printStackTrace();
		}
	}
	
	public void click(int noTimes)throws AWTException{
		for(int i=0;i<noTimes;i++){
			Robot robo=new Robot();
			robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);	
		}
		
	}
	
	/**
	 * Moves the mouse to the position passed
	 * 
	 * @author Pradeep Sundaram
	 * @param xPosition
	 * @param yPosition
	 */
	public void moveToPosition(int xPosition, int yPosition){
		try{
			Robot robot=new Robot();
			robot.mouseMove(xPosition, yPosition);	
		}
		catch(AWTException ie){
			Report.log("AWT Exception");
			ie.printStackTrace();
		}
	}
	
	/**
	 * This method will type the text in webElement passed as arguments
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws CFException 
	 */
	@Override
	public void mouseOver(WebElement webElement) throws CFException {
		action = new Actions(driver);
		action.moveToElement(webElement).perform();
		write("Moving mouse over " + WebPage.elementList.get(webElement)
				+ "<BR>");
	}
	
	/**
	 * This method will type the text in webElement passed as arguments
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @param text
	 * @throws CFException 
	 */
	public void type(WebElement webElement, String text) throws CFException  {
		webElement.clear();
		webElement.sendKeys(text);
		write("<b>Typing \'"+text+"\' in '"+WebPage.elementList.get(webElement)+"'");
	}
	
	
	/**
	 * This method select the text in drop down for the passed index
	 * 
	 * @author Pradeep Sundaram
	 * @param selectField
	 * @param index
	 * @throws CFException 
	 */
	public void select(Select selectField,int index) throws CFException {
		selectField.selectByIndex(index);
		write("<b>Selecting the " + index + "th element in "+ WebPage.elementList.get(selectField));	
		
	}

	/**
	 * This method selects the text in drop down for the passed value
	 * 
	 * @author Pradeep Sundaram
	 * @param selectField
	 * @param value
	 * @throws CFException 
	 */
	public  void selectByValue(Select selectField, String value) throws CFException {
		selectField.selectByValue(value);
		write("<b>Selecting \'" + value + "\' in "+WebPage.elementList.get(selectField));
		
		
	}

	/**
	 * This method selects the passed text in the drop down
	 * 
	 * @author Pradeep Sundaram
	 * @param selectField
	 * @param selectString
	 * @throws CFException 
	 */
	public void selectByText(Select selectField, String selectString) throws CFException {
		selectField.selectByVisibleText(selectString);
		write("<b>Selecting \'" + selectString + "\' in "+ WebPage.elementList.get(selectField));	
	}
	
	/**
	 * This method will check the check box if it is unchecked
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @param text
	 * @throws CFException 
	 */
	public void check(WebElement webElement) throws CFException {
		if (!webElement.isSelected()) { //checks whether check box is unchecked
			webElement.click();
		}
		write("<b>Checking \'"+ WebPage.elementList.get(webElement));
		
	}
    
	
	 /**
	  * this method will uncheck the check box if it is checked, leaves it if the check 
	  * box is not checked
	  * 
	  * @author Pradeep Sundaram
	  * @param webElement
	  * @param text
	 * @throws CFException 
	  */
	public void unCheck(WebElement webElement) throws CFException{
		if (webElement.isSelected()) { // checks whether check box is checked
			webElement.click();
		}
		write("<b>Un Checking \'"+ WebPage.elementList.get(webElement));	
	}
	
	/**
	 * This method will write trace and take screen shot and put the screen shot in the destination location and link the screen shot with the report
	 * 
	 * @author Pradeep Sundaram
	 * @param logMessage
	 * @param counter
	 * @throws CFException 
	 */
	public void write(String logMessage) throws CFException{
		String path=null;
		if(WebPage.screenshotRequired){
			try{
				String hyperLink=ScreenShotInitial+counter+ScreenShotEnd;
				String message=logMessage+hyperLink;
				File directory = new File (".");
				path=directory.getCanonicalPath()+"\\test-output\\screenshot\\";
				File f=new File(path+counter+".png");
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
				FileUtils.copyFile(scrFile, f);
				Report.log(message);
				counter++;
			}
			catch(UnhandledAlertException alertException){
				Report.log(logMessage+"<font color=\"#FF0000\"> \"Due to Alert box, not able to take screen shot\" </font>");
			}
			catch(Exception ioe){
				throw new CFException(ioe.getMessage());
			}	
		}
		else{
			Report.log(logMessage);
		}
	}
	
	/**
	 * This method will choose the radio button
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws CFException 
	 */
	public void choose(WebElement webElement) throws CFException{
		if (!webElement.isSelected()) {// checks whether check box is unchecked
			webElement.click();
		}
		else{
			Report.log("the radio button is already selected");	
		}
		write("<b>Choosing \'" + WebPage.elementList.get(webElement));
	}
}
