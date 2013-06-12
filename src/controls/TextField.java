package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import utils.Events;

public class TextField {
	
	private WebElement textField;
	private By by;
	String txtDescription;
	
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
	
	/**
	 * Normal Constructor for Text field
	 * @author Pradeep Sundaram
	 * @param txtField
	 * @param desc
	 */
	public TextField(WebElement txtField, String desc) {
		textField = txtField;
		WebPage.elementList.put(textField, desc);
	}
	
	
	public TextField(String textID,String fieldDesc){
		if(textID.startsWith("id")){
			textField=ElementUtil.findElementByID(textID);
		}
		else if(textID.startsWith("name")){
			textField=ElementUtil.findElementByName(textID);
		}
		else if(textID.startsWith("css")){
			textField=ElementUtil.findElementByCss(textID);
		}
		else if(textID.startsWith("//")){
			textField=ElementUtil.findElementByXpath(textID);
		}
		WebPage.elementList.put(textField, fieldDesc);
	}
	
	public TextField(String textID,By byOfTf,String fieldDesc){
		if(textID.startsWith("id")){
			textField=ElementUtil.findElementByID(textID);
		}
		else if(textID.startsWith("name")){
			textField=ElementUtil.findElementByName(textID);
		}
		else if(textID.startsWith("css")){
			textField=ElementUtil.findElementByCss(textID);
		}
		by=byOfTf;
		WebPage.elementList.put(textField, fieldDesc);
	}
	
	/**
	 * Constructor for text field when By of the text field is required
	 * @author Pradeep Sundaram
	 * @param txtField
	 * @param by
	 * @param desc
	 */
	public TextField(WebElement txtField, By byOfTextField, String desc) {
		by=byOfTextField;
		textField = txtField;
		WebPage.elementList.put(textField, desc);
	}

	/**
	 * This method will type the text in Text Field
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 * @throws IOException
	 */
	public void type(String text) throws IOException {
		Events.type(textField, text);
	}
	
	/**
	 * This method will click in the Text Field for Date controls
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void click() throws IOException {
		Events.click(textField);
	}
	
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
		return textField.isDisplayed();
	}	
	/**
	 * will return true if the text field is enabled else false will be returned
	 * 
	 * @return
	 */
	public boolean isEnabled() {
		return textField.isEnabled();
	}
	
}
