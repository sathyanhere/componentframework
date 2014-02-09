package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class RadioButton {
	private WebElement radioButton;
	private By by;
	private ElementUtil elementUtil;
	
	/**
	 * Constructor of radio button 
	 * 
	 * @author PSubramani33
	 * @param radioButtonName
	 * @param description
	 */
	public RadioButton(String radioButtonName,String description, ElementUtil util){
		elementUtil=util;
		if(radioButtonName.startsWith("name")){
			by=elementUtil.byName(radioButtonName);
		}
		else if(radioButtonName.startsWith("css")){
			by=elementUtil.byCss(radioButtonName);
		}
		else if(radioButtonName.startsWith("//")){
			by=elementUtil.byXpath(radioButtonName);
		}
		else if(radioButtonName.startsWith("id")){
			by=elementUtil.byID(radioButtonName);
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
	 * @throws IOException
	 */
	public void choose() throws IOException{
		radioButton=elementUtil.findElement(by);
		elementUtil.choose(radioButton);
	}
	
	/**
	 * This method will return the By for the Check Box
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement(){
		return radioButton;
	}
	
	
	/**
	 * will return boolean based on the presence of the radio button
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field \"" + WebPage.elementList.get(radioButton)+"\" is displayed.<BR>");
      return radioButton.isDisplayed();
	}
	
	/**
	 * will return true when radio button is there in the page, will return true even it is not displayed in the page.
	 * using java script the radio button may not be visible but radio button may there in the page.
	 * @return
	 */
	public boolean isEnabled() {
		Report.log("Checking whether the field \"" + WebPage.elementList.get(radioButton)+"\" is enabled.<BR>");
      return radioButton.isEnabled();
	}
}
