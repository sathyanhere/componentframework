package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Link {
	private WebElement link;
	private By by;
//	private ElementUtil elementUtil;
	String linkName;

	public Link(String linkText,String desc){
		if(linkText.startsWith("id")){
			by=ElementUtil.byID(linkText);
		}
		
		else if(linkText.startsWith("css")){
			by=ElementUtil.byCss(linkText);
		}
		
		else if(linkText.startsWith("//")){
			by=ElementUtil.byXpath(linkText);
		}
		
		else if(linkText.startsWith("link")){
			by=ElementUtil.byLinkText(linkText);
		}
		WebPage.elementList.put(link, desc);
	}
	
	public Link(String linkText){
		link=ElementUtil.findElementByLinkText(linkText);
		WebPage.elementList.put(link, linkText);
	}
	
	/**
	 * This method will click in the link passed as argument
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void click() throws IOException {
		link=ElementUtil.findElement(by);
		ElementUtil.click(link);
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
		link=ElementUtil.findElement(by);
		return link.getText();
	}
	/**
	 * This method will return the webelement of the link
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement(){
		link=ElementUtil.findElement(by);
		return link;
	}
	
	
	/**
	 * will return boolean based on the presence of the link
	 * 
	 * @author Pradeep Sundaram 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		link=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(link)+"\" is displayed.<BR>");
		return link.isDisplayed();
	}
}
