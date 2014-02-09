package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Link {
	private WebElement link;
	private By by;
	private ElementUtil elementUtil;
	String linkName;

	public Link(String linkText,String desc, ElementUtil util){
		elementUtil=util;
		if(linkText.startsWith("id")){
			by=elementUtil.byID(linkText);
		}
		
		else if(linkText.startsWith("css")){
			by=elementUtil.byCss(linkText);
		}
		
		else if(linkText.startsWith("//")){
			by=elementUtil.byXpath(linkText);
		}
		
		else if(linkText.startsWith("link")){
			by=elementUtil.byLinkText(linkText);
		}
		WebPage.elementList.put(link, desc);
	}
	
	public Link(String linkText){
		link=elementUtil.findElementByLinkText(linkText);
		WebPage.elementList.put(link, linkText);
	}
	
	/**
	 * This method will click in the link passed as argument
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void click() throws IOException {
		link=elementUtil.findElement(by);
		elementUtil.click(link);
	}
	
	/**
	 * This method will return the By for the button
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the text displayed in the text
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public String getText(){
		return link.getText();
	}
	/**
	 * This method will return the webelement of the link
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement(){
		return link;
	}
	
	
	/**
	 * will return boolean based on the presence of the link
	 * 
	 * @author Pradeep Sundaram 
	 * @return boolean
	 */
	public boolean isDisplayed() { 
		Report.log("Checking whether the field \"" + WebPage.elementList.get(link)+"\" is displayed.<BR>");
		return link.isDisplayed();
	}
}
