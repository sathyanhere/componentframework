package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import utils.Events;

public class DateControl {
	private WebElement dateControl;
	private By by;
	
	public DateControl(WebElement date, String desc) {
		dateControl = date;
		WebPage.elementList.put(dateControl, desc);
	}
	
	/**
	 * Constructor for DateControl when By of the DateControl is required
	 * @author Pradeep Sundaram
	 * @param date
	 * @param byOfDateControl
	 * @param desc
	 */
	public DateControl(WebElement date,By byOfDateControl, String desc) {
		dateControl = date;
		by=byOfDateControl;
		WebPage.elementList.put(dateControl, desc);
	}
	
	
	public DateControl(String dateControlName,String description){
		if(dateControlName.startsWith("name")){
			dateControl=ElementUtil.findElementByName(dateControlName);
		}
		else if(dateControlName.startsWith("css")){
			dateControl=ElementUtil.findElementByCss(dateControlName);
		}
		else if(dateControlName.startsWith("//")){
			dateControl=ElementUtil.findElementByXpath(dateControlName);
		}
		else if(dateControlName.startsWith("id")){
			dateControl=ElementUtil.findElementByID(dateControlName);
		}
		else{
			System.out.println("button is not found");
		}
		WebPage.elementList.put(dateControl, description);
	}
	
	/**
	 * This method will select a date in Date controls
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void click() throws IOException {
		Events.click(dateControl);
	}
	/**
	 * This method will return By of the dateControl
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy(){
		return by;
	}
	
	/**
	 * This method will return the webelement for date control
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement(){
		return dateControl;
	}
}
