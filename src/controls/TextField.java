package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class TextField {
	
	private WebElement textField;
	private By by;
	String txtDescription;
	
	
	/**
	 * @author Pradeep Sundaram 
	 * @param textID
	 * @param fieldDesc
	 */
	public TextField(WebElement textID,String fieldDesc){
		textField=textID;
		txtDescription=fieldDesc;
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
	 * This method will return the webElement of the text field
	 * @author Pradeep Sundaram
	 * @return 
	 */
	public WebElement getWebElement(){
		if (by != null) {
			textField=ElementUtil.findElement(by);	
		}
		
		return textField;
	}
	
	public TextField(String textID,String fieldDesc){
		txtDescription=fieldDesc;
		if(textID.startsWith("id")){
			by=ElementUtil.byID(textID);
		}
		else if(textID.startsWith("name")){
			by=ElementUtil.byName(textID);
		}
		else if(textID.startsWith("css")){
			by=ElementUtil.byCss(textID);
		}
		else if(textID.startsWith("//")|| textID.startsWith("(")){
			by=ElementUtil.byXpath(textID);
		}
	}
	
	/**
	 * This method will type the text in Text Field
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 */
	public void type(String text){
		if (by != null) {
			textField=ElementUtil.findElement(by);	
		}
		WebPage.elementList.put(textField, txtDescription);
		ElementUtil.type(textField, text);
	}
	
	/**
	 * This method will click in the Text Field for Date controls
	 * 
	 * @author Pradeep Sundaram
	 */
	/*public void click()  {
		Events.click(textField);
	}*/
	
	/**
	 * This method will return the text in the text field
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 */ 
	public String getText(){
		if (by != null) {
			textField=ElementUtil.findElement(by);			
		}
		return textField.getAttribute("value");	
	}
	
	/**
	 * will return boolean based on the presence of the text field
	 * 
	 * @author Pradeep Sundaram S
	 * @return boolean
	 */
	public boolean isDisplayed() {
		if (by != null) {
			textField=ElementUtil.findElement(by);			
		}
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textField)+"\" is displayed.<BR>");
		return textField.isDisplayed();
	}	
	/**
	 * will return true if the text field is enabled else false will be returned
	 * 
	 * @author Pradeep Sundaram 
	 * @return boolean
	 */
	public boolean isEnabled() {
		if (by != null) {
			textField=ElementUtil.findElement(by);			
		}
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textField)+"\" is displayed.<BR>");
		return textField.isEnabled();
	}
	
}
