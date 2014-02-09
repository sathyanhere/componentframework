package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class TextArea {
	private WebElement textArea;
	private By by;
	private ElementUtil elementUtil;
	
	public TextArea(String textAreaName,String description, ElementUtil util){
		elementUtil=util;
		if(textAreaName.startsWith("name")){
			by=elementUtil.byName(textAreaName);
		}
		else if(textAreaName.startsWith("css")){
			by=elementUtil.byCss(textAreaName);
		}
		else if(textAreaName.startsWith("//")){
			by=elementUtil.byXpath(textAreaName);
		}
		else if(textAreaName.startsWith("id")){
			by=elementUtil.byID(textAreaName);
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
	public void type(String text) throws IOException {
		elementUtil.findElement(by);
		elementUtil.type(textArea, text);
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
		Report.log("Checking whether the field \"" + WebPage.elementList.get(textArea)+"\" is displayed.<BR>");
		return textArea.isDisplayed();
	}
}
