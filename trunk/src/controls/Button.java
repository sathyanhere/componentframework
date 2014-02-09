package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Button {
	private WebElement button;
	private By by;
	private ElementUtil elementUtil;

	/**
	 * Constructor for button when mouse over or double click is required for
	 * the button
	 * 
	 * @author PSubramani33
	 * @param buttonID
	 * @param buttonDesc
	 * @param util
	 * @param events
	 */
	public Button(String buttonID, String buttonDesc, ElementUtil util) {
		elementUtil=util;
		if (buttonID.startsWith("name")) {
			by=util.byName(buttonID);
		} else if (buttonID.startsWith("css")) {
			by=util.byCss(buttonID);
		} else if (buttonID.startsWith("//")) {
			by=util.byXpath(buttonID);
		} else if (buttonID.startsWith("id")) {
			by=util.byID(buttonID);
		} else {
			Report.log("button is not found");
		}
		WebPage.elementList.put(button, buttonDesc);
	}


	/**
	 * This method will return the By of the text field
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}

	/**
	 * This method will click in the button
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException 
	 */
	public void click() throws IOException {
		button=elementUtil.findElement(by);
		elementUtil.click(button);
//		events.click(button);
	}

	/**
	 * this method will double click on the button
	 * 
	 * @author PSubramani33
	 */
	/*public void doubleClick() {
		events.doubleClick(button);
	}*/

	/**
	 * This method will return the webElement of the button
	 * 
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement() {
		return button;
	}

	/**
	 * will return boolean based on the presence of the button
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field "
				+ WebPage.elementList.get(button) + " is displayed.<BR>");
		return button.isDisplayed();
	}

	/**
	 * This method will return the tool tip of the button
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		Report.log("Getting the tool tip of the button "
				+ WebPage.elementList.get(button) + ".<BR>");
		return button.getAttribute("title");
	}
}
