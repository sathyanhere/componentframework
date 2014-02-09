package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class TextField {
	
	private WebElement textField;
	private By by;
	String txtDescription;
	private ElementUtil elementUtil;	
	/**
	 * This method will return the By of the text field
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy(){
		return by;
	}
	
	/**
	 * This method will return the webElement of the text field
	 * @author Pradeep Sundaram
	 * @return 
	 */
	public WebElement getWebElement(){
		return textField;
	}
	
	public TextField(String textID,String fieldDesc, ElementUtil util){
		elementUtil=util;
		txtDescription=fieldDesc;
		if(textID.startsWith("id")){
			by=util.byID(textID);
		}
		else if(textID.startsWith("name")){
			by=util.byName(textID);
		}
		else if(textID.startsWith("css")){
			by=util.byCss(textID);
		}
		else if(textID.startsWith("//")){
			by=util.byXpath(textID);
		}
	}
	
	/**
	 * This method will type the text in Text Field
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 * @throws IOException
	 */
	public void type(String text) throws IOException {
		textField=elementUtil.findElement(by);
		WebPage.elementList.put(textField, txtDescription);
		elementUtil.type(textField, text);
	}
	
	/**
	 * This method will click in the Text Field for Date controls
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	/*public void click() throws IOException {
		Events.click(textField);
	}*/
	
	/**
	 * This method will return the text in the text field
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public String getText(){
		return textField.getAttribute("value");	
	}
	
	/**
	 * will return boolean based on the presence of the text field
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textField)+"\" is displayed.<BR>");
		return textField.isDisplayed();
	}	
	/**
	 * will return true if the text field is enabled else false will be returned
	 * 
	 * @return
	 */
	public boolean isEnabled() {
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textField)+"\" is displayed.<BR>");
		return textField.isEnabled();
	}
	
}
