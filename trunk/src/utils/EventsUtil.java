package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import events.KeyEvents;
import events.WindowEvents;

import pages.WebPage;
import reports.Report;

public class EventsUtil implements KeyEvents, WindowEvents{

	public Robot robot;
	public Actions builder;

	/*@Override
	public void mouseOver(WebElement webElement) {
		builder.moveToElement(webElement).perform();
		Report.log("Moving mouse over " + WebPage.elementList.get(webElement)
				+ "<BR>");
	}*/
	
	@Override
	public void doubleClick(WebDriver driver, WebElement webElement) {
		builder=new Actions(driver);
		builder.doubleClick(webElement);
		Report.log("Moving mouse over " + WebPage.elementList.get(webElement));
	}
	

	@Override
	public void pressEscKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Report.log("Pressing Esc key ");

		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	@Override
	public void pressBackSpace() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			Report.log("Pressing back space key ");
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	@Override
	public void pressTabKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Report.log("Pressing TAB key ");
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	public void keyDownAlt()  {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_ALT);
			Report.log("key down Alt key ");
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}
	
	@Override
	public void pressShiftTabKey(int howManyTimes)   {
		try{
			robot = new Robot();
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.delay(500);
			this.pressTabKey(howManyTimes);
			robot.delay(500);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			Report.log("Pressing Shift+TAB keys " + howManyTimes + " times ");
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	@Override
	public void pressTabKey(int howManyTimes)   {
		try{
			robot = new Robot();
			for (int i = 0; i < howManyTimes; i++) {
				robot.delay(500);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}
			Report.log("Pressing TAB key for " + howManyTimes + " times ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	@Override
	public void pressEnterKey()   {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Report.log("Pressing ENTER key ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	@Override
	public void pressSpaceBar()   {
		try{
			robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	@Override
	public void selectFrame(WebDriver driver, String frameName) {
		Report.log("switching to the frame '"+frameName+"'");
		driver.switchTo().frame(frameName);
		
	}

	@Override
	public void selectWindow(WebDriver driver, String windowName) {
		Report.log("switching to the window '"+windowName+"'");
		driver.switchTo().window(windowName);
	}
	
	
	@Override
	public void switchToMainPage(WebDriver driver) {
		Report.log("switching the control to main window");
		driver.switchTo().defaultContent();
	}
	

	@Override
	public void type(String text) {
		try {
			robot = new Robot();
			char[] textArr = text.toCharArray();
			int size = textArr.length;
			for (int i = 0; i < size; i++) {
				robot.delay(500);
				robot.keyPress((int)textArr[i]);
				Report.log("Entering " + textArr[i]);
			}
		} catch (AWTException awte) {
			awte.printStackTrace();
		}

	}

	@Override
	public void pressShiftKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_SHIFT);
			Report.log("Pressing shift key ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
	}
	
	@Override
	public void pressCtrlKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_CONTROL);
			Report.log("Pressing ctrl key ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
	}


	@Override
	public void releaseCtrlKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Report.log("Releasing ctrl key ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
	}

	@Override
	public void releaseShiftKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			Report.log("Pressing shift key ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
		
	}

	/**
	 * presses down arrow key
	 * 
	 * @author Pradeep Sundaram
	 */
	@Override
	public void pressDownKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_DOWN);
			Report.log("Pressing down arrow key ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
	}

	/**
	 * Releases down arrow key
	 * 
	 * @author Pradeep Sundaram
	 */
	@Override
	public void releaseDownKey() {
		try{
			robot = new Robot();
			robot.delay(500);
			robot.keyRelease(KeyEvent.VK_DOWN);
			Report.log("Releasing down arrow key ");	
		}
		catch(AWTException awte){
			awte.printStackTrace();
		}
	}
	
}
