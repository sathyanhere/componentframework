package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import exception.CFException;

public class DateControl {
	private WebElement dateControl;
	private By by;
//	private ElementUtil elementUtil;
	
	public DateControl(WebElement date, String desc) {
		dateControl = date;
		WebPage.elementList.put(dateControl, desc);
	}
	
	public DateControl(String dateControlName,String description){
		if(dateControlName.startsWith("name")){
			by=ElementUtil.byName(dateControlName);
		}
		else if(dateControlName.startsWith("css")){
			by=ElementUtil.byCss(dateControlName);
		}
		else if(dateControlName.startsWith("//")|| dateControlName.startsWith("(")){
			by=ElementUtil.byXpath(dateControlName);
		}
		else if(dateControlName.startsWith("id")){
			by=ElementUtil.byID(dateControlName);
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
	 */
	public void click() {
		dateControl=ElementUtil.findElement(by);
		try {
			ElementUtil.click(dateControl);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will return By of the dateControl
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy(){
		return by;
	}
	
	/**
	 * This method will return the webelement for date control
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		dateControl=ElementUtil.findElement(by);
		return dateControl;
	}
}
