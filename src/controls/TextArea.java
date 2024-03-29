package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class TextArea {
	private WebElement textArea;
	private By by;
	String desc;
//	private ElementUtil elementUtil;
	
	public TextArea(WebElement textAreaName,String description){
		textArea=textAreaName;
		desc=description;
	}
	
	public TextArea(String textAreaName,String description){
		if(textAreaName.startsWith("name")){
			by=ElementUtil.byName(textAreaName);
		}
		else if(textAreaName.startsWith("css")){
			by=ElementUtil.byCss(textAreaName);
		}
		else if(textAreaName.startsWith("//")|| textAreaName.startsWith("(")){
			by=ElementUtil.byXpath(textAreaName);
		}
		else if(textAreaName.startsWith("id")){
			by=ElementUtil.byID(textAreaName);
		}
		else{
			System.out.println("button is not found");
		}
		WebPage.elementList.put(textArea, description);
	}
	
	/**
	 * This method will type the passed text in TextArea
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 * @throws IOException
	 */
	public void type(String text){
		if (by != null) {
			textArea=ElementUtil.findElement(by);			
		}
		ElementUtil.type(textArea, text);
	}
	
	/**
	 * This method will return the By for the Text Area
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the textarea
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		if (by != null) {
			textArea=ElementUtil.findElement(by);			
		}
		return textArea;
	}
	
	/**
	 * will return boolean based on the presence of the text area
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		if (by != null) {
			textArea=ElementUtil.findElement(by);			
		}
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textArea)+"\" is displayed.<BR>");
		return textArea.isDisplayed();
	}
}
