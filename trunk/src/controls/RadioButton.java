package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class RadioButton {
	private WebElement radioButton;
	private By by;
//	private ElementUtil elementUtil;
	String desc;
	/**
	 * 
	 * 
	 * @author Pradeep Sundaram
	 * @param radioButtonName
	 * @param description
	 */
	public RadioButton(WebElement radioButtonName,String description){
		radioButton=radioButtonName;
		desc=description;
	}
	
	
	
	/**
	 * Constructor of radio button 
	 * 
	 * @author PSubramani33
	 * @param radioButtonName
	 * @param description
	 */
	public RadioButton(String radioButtonName,String description){
		if(radioButtonName.startsWith("name")){
			by=ElementUtil.byName(radioButtonName);
		}
		else if(radioButtonName.startsWith("css")){
			by=ElementUtil.byCss(radioButtonName);
		}
		else if(radioButtonName.startsWith("//")|| radioButtonName.startsWith("(")){
			by=ElementUtil.byXpath(radioButtonName);
		}
		else if(radioButtonName.startsWith("id")){
			by=ElementUtil.byID(radioButtonName);
		}
		else{
			System.out.println("button is not found");
		}
		WebPage.elementList.put(radioButton, description);
	}
	
	/**
	 * This method will choose the radio button
	 * 
	 * @author Pradeep Sundaram
	 */
	public void choose() {
		if (by != null) {
			radioButton=ElementUtil.findElement(by);			
		}
		try {
			ElementUtil.choose(radioButton);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will return the By for the Check Box
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		if (by != null) {
			radioButton=ElementUtil.findElement(by);	
		}
		return radioButton;
	}
	
	
	/**
	 * will return boolean based on the presence of the radio button
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		if (by != null) {
			radioButton=ElementUtil.findElement(by);			
		}
		Report.log("Checking whether the field \"" + WebPage.elementList.get(radioButton)+"\" is displayed.<BR>");
      return radioButton.isDisplayed();
	}
	
	/**
	 * will return true when radio button is there in the page, will return true even it is not displayed in the page.
	 * using java script the radio button may not be visible but radio button may there in the page.
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isEnabled() {
		if (by != null) {
			radioButton=ElementUtil.findElement(by);			
		}
		Report.log("Checking whether the field \"" + WebPage.elementList.get(radioButton)+"\" is enabled.<BR>");
      return radioButton.isEnabled();
	}
}
