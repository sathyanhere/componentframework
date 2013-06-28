package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class Button {
	private WebElement button;
	private By by;
	
	public Button(WebElement buttonName, String buttonDesc) {
		button = buttonName;
		
		WebPage.elementList.put(button, buttonDesc);
	}
	
	
	public Button(String buttonID,String buttonDesc){
		if(buttonID.startsWith("name")){
			button=ElementUtil.findElementByName(buttonID);
		}
		else if(buttonID.startsWith("css")){
			button=ElementUtil.findElementByCss(buttonID);
		}
		else if(buttonID.startsWith("//")){
			button=ElementUtil.findElementByXpath(buttonID);
		}
		else if(buttonID.startsWith("id")){
			button=ElementUtil.findElementByID(buttonID);
		}
		else{
			System.out.println("button is not found");
		}
		WebPage.elementList.put(button, buttonDesc);
	}
	
	
	public Button(String buttonID,By byOfButton, String buttonDesc){
		if(buttonID.startsWith("name")){
			button=ElementUtil.findElementByName(buttonID);
		}
		else if(buttonID.startsWith("css")){
			button=ElementUtil.findElementByCss(buttonID);
		}
		else if(buttonID.startsWith("//")){
			button=ElementUtil.findElementByXpath(buttonID);
		}
		else if(buttonID.startsWith("id")){
			button=ElementUtil.findElementByID(buttonID);
		}
		else{
			System.out.println("button is not found");
		}
		by=byOfButton;
		WebPage.elementList.put(button, buttonDesc);
	}
	
	
	/**
	 * Constructor for button when By of the button is required
	 * @author Pradeep Sundaram
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
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy(){
		return by;
	}
	
	/**
	 * This method will click in the button
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void click() throws IOException {
		Events.click(button);
	}
	/**
	 * This method will return the webElement of the button
	 * @author Pradeep Sundaram
	 * @return 
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
		Report.log("Checking whether the field \"" + WebPage.elementList.get(button)+"\" is displayed.<BR>");
		return button.isDisplayed();
	}
}
