package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import utils.Events;

public class Button {
	private WebElement button;
	private By by;
	
	public Button(WebElement buttonName, String buttonDesc) {
		button = buttonName;
		WebPage.elementList.put(button, buttonDesc);
	}
	
	/**
	 * Constructor for button when By of the button is required
	 * @author PSubramani33
	 * @param buttonName
	 * @param byOfButton
	 * @param buttonDesc
	 */
	public Button(WebElement buttonName, By byOfButton, String buttonDesc) {
		by=byOfButton;
		button = buttonName;
		WebPage.elementList.put(button, buttonDesc);
	}
	
	/**
	 * This method will return the By of the text field
	 * @author PSubramani33
	 * @return
	 */
	public By getBy(){
		return by;
	}
	
	/**
	 * This method will click in the button
	 * 
	 * @author PSubramani33
	 * @throws IOException
	 */
	public void click() throws IOException {
		Events.click(WebPage.driver, button);
	}
	/**
	 * This method will return the webElement of the button
	 * @author PSubramani33
	 * @return 
	 */
	public WebElement getWebElement() {
		return button;
	}
	
}
