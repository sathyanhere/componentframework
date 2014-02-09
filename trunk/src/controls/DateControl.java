package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;

public class DateControl {
	private WebElement dateControl;
	private By by;
	private ElementUtil elementUtil;
	public DateControl(WebElement date, String desc) {
		dateControl = date;
		WebPage.elementList.put(dateControl, desc);
	}
	
	public DateControl(String dateControlName,String description,ElementUtil util){
		elementUtil=util;
		if(dateControlName.startsWith("name")){
			by=util.byName(dateControlName);
		}
		else if(dateControlName.startsWith("css")){
			by=util.byCss(dateControlName);
		}
		else if(dateControlName.startsWith("//")){
			by=util.byXpath(dateControlName);
		}
		else if(dateControlName.startsWith("id")){
			by=util.byID(dateControlName);
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
		dateControl=elementUtil.findElement(by);
		elementUtil.click(dateControl);
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
