package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Button {
	private WebElement button;
	private String desc;
	private By by;
//	private ElementUtil elementUtil;

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
	public Button(String buttonID, String buttonDesc) {
//		elementUtil=util;
		desc=buttonDesc;
		if (buttonID.startsWith("name")) {
			by=ElementUtil.byName(buttonID);
		} else if (buttonID.startsWith("css")) {
			by=ElementUtil.byCss(buttonID);
		} else if (buttonID.startsWith("//")) {
			by=ElementUtil.byXpath(buttonID);
		} else if (buttonID.startsWith("id")) {
			by=ElementUtil.byID(buttonID);
		} else {
			Report.log("button is not found");
		}
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
	public void click() {
		button=ElementUtil.findElement(by);
		WebPage.elementList.put(button, desc);
		ElementUtil.click(button);
//		events.click(button);
	}

	/**
	 * this method will double click on the button
	 * 
	 * @author PSubramani33
	 */
	public void doubleClick() {
		ElementUtil.doubleClick(button);
	}

	/**
	 * This method will return the webElement of the button
	 * 
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement() {
		button=ElementUtil.findElement(by);
		return button;
	}

	/**
	 * will return boolean based on the presence of the button
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		button=ElementUtil.findElement(by);
		Report.log("Checking whether the field "+WebPage.elementList.get(button) + " is displayed.<BR>");
		return button.isDisplayed();
	}

	/**
	 * This method will return the tool tip of the button
	 * 
	 * @author PSubramani33
	 * @return String
	 */
	public String getToolTip() {
		button=ElementUtil.findElement(by);
		Report.log("Getting the tool tip of the button "+WebPage.elementList.get(button) + ".<BR>");
		return button.getAttribute("title");
	}
}
