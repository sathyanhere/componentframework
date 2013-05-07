package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class TextArea {
	private WebElement textArea;
	private By by;

	public TextArea(WebElement textAreaName, String description) {
		textArea = textAreaName;
		WebPage.elementList.put(textAreaName, description);
	}
	
	/**
	 * Constructor for text area when By of the text area is required
	 * @author Pradeep Sundaram
	 * @param textAreaName
	 * @param byOfTextArea
	 * @param description
	 */
	public TextArea(WebElement textAreaName,By byOfTextArea, String description) {
		textArea = textAreaName;
		by=byOfTextArea;
		WebPage.elementList.put(textAreaName, description);
	}
	
	
	public TextArea(String textAreaName,String description){
		if(textAreaName.startsWith("name")){
			textArea=ElementUtil.findElementByName(textAreaName);
		}
		else if(textAreaName.startsWith("css")){
			textArea=ElementUtil.findElementByCss(textAreaName);
		}
		else if(textAreaName.startsWith("//")){
			textArea=ElementUtil.findElementByXpath(textAreaName);
		}
		else if(textAreaName.startsWith("id")){
			textArea=ElementUtil.findElementByID(textAreaName);
		}
		else{
			System.out.println("button is not found");
		}
		WebPage.elementList.put(textArea, description);
	}
	
	public TextArea(String textAreaName,By byOfTA,String description){
		if(textAreaName.startsWith("name")){
			textArea=ElementUtil.findElementByName(textAreaName);
		}
		else if(textAreaName.startsWith("css")){
			textArea=ElementUtil.findElementByCss(textAreaName);
		}
		else if(textAreaName.startsWith("//")){
			textArea=ElementUtil.findElementByXpath(textAreaName);
		}
		else if(textAreaName.startsWith("id")){
			textArea=ElementUtil.findElementByID(textAreaName);
		}
		by=byOfTA;
		WebPage.elementList.put(textArea, description);
	}
	
	/**
	 * This method will type the passed text in TextArea
	 * 
	 * @author Pradeep Sundaram
	 * @param text
	 * @throws IOException
	 */
	public void type(String text) throws IOException {
		Events.type(textArea, text);
	}
	
	/**
	 * This method will return the By for the Text Area
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the textarea
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement(){
		return textArea;
	}
	
	/**
	 * will return boolean based on the presence of the text area
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field " + WebPage.elementList.get(textArea)+" is displayed.<BR>");
		return textArea.isDisplayed();
	}
}
