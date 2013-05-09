package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pages.WebPage;
import reports.Report;

public class EventsUtil implements MouseEvents, KeyEvents, WindowEvents {

	public Robot robot;
	public Actions builder;

	@Override
	public void mouseOver(WebElement webElement) {
		builder = new Actions(WebPage.driver);
		builder.moveToElement(webElement).perform();
		Report.log("Moving mouse over " + WebPage.elementList.get(webElement)
				+ "<BR>");
	}

	@Override
	public void pressEscKey() throws AWTException {
		robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Report.log("Pressing Esc key <BR>");

	}

	@Override
	public void pressBackSpace() throws AWTException {
		robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Report.log("Pressing back space key <BR>");
	}

	@Override
	public void pressTabKey() throws AWTException {
		robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		Report.log("Pressing TAB key <BR>");
	}

	@Override
	public void pressShiftTabKey(int howManyTimes) throws AWTException {
		robot = new Robot();
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.delay(500);
		this.pressTabKey(howManyTimes);
		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		Report.log("Pressing Shift+TAB keys " + howManyTimes + " times <BR>");
	}

	@Override
	public void pressTabKey(int howManyTimes) throws AWTException {
		robot = new Robot();
		for (int i = 0; i < howManyTimes; i++) {
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
		}
		Report.log("Pressing TAB key for " + howManyTimes + " times <BR>");
	}

	@Override
	public void pressEnterKey() throws AWTException {
		robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Report.log("Pressing ENTER key <BR>");
	}

	@Override
	public void pressSpaceBar() throws AWTException {
		robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_SPACE);
	}

	@Override
	public void selectFrame(String frameName) {
		WebPage.driver.switchTo().frame(frameName);
	}

	@Override
	public void selectWindow(String windowName) {
		WebPage.driver.switchTo().window(windowName);
	}

	@Override
	public void type(String text) throws AWTException {
		robot = new Robot();
		robot.delay(500);
		String[] textArray = text.split("");
		for (int i = 1; i < textArray.length; i++) {
			robot.delay(500);
			robot.keyPress(TextUtil.getAsciiValue(textArray[i]));
			Report.log("Entering " + textArray[i] + "<BR>");
		}
	}

}
