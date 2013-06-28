package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class Link {
	private WebElement link;
	private By by;
	
	String linkName;

	
	/**
	 * Constructor for Link when By of the link is required
	 * @author Pradeep Sundaram
	 * @param linkText
	 * @param byOfLink
	 * @param desc
	 */
	public Link(WebElement linkText,By byOfLink, String desc) {
		link = linkText;
		by=byOfLink;
		WebPage.elementList.put(link, desc);
	}
	public Link(WebElement linkText, String desc) {
		link = linkText;
		WebPage.elementList.put(link, desc);
	}

	/*public Link(String text){
		link=WebPage.driver.findElement(By.linkText(text));
		WebPage.elementList.put(link, text);
	}*/
	
	
	public Link(String linkText,String desc){
		if(linkText.startsWith("id")){
			link=ElementUtil.findElementByID(linkText);
		}
		
		else if(linkText.startsWith("css")){
			link=ElementUtil.findElementByCss(linkText);
		}
		
		else if(linkText.startsWith("//")){
			link=ElementUtil.findElementByXpath(linkText);
		}
		
		else if(linkText.startsWith("link")){
			link=ElementUtil.findElementByLinkText(linkText);
		}
		WebPage.elementList.put(link, desc);
	}
	
	public Link(String linkText){
		if(linkText.startsWith("id")){
			link=ElementUtil.findElementByID(linkText);
		}
		
		else if(linkText.startsWith("css")){
			link=ElementUtil.findElementByCss(linkText);
		}
		
		else if(linkText.startsWith("//")){
			link=ElementUtil.findElementByXpath(linkText);
		}
		
		else if(linkText.startsWith("link")){
			link=ElementUtil.findElementByLinkText(linkText);
		}
		WebPage.elementList.put(link, linkText);
	}
	
	public Link(String linkText,By byOfLink){
		if(linkText.startsWith("id")){
			link=ElementUtil.findElementByID(linkText);
		}
		
		else if(linkText.startsWith("css")){
			link=ElementUtil.findElementByCss(linkText);
		}
		
		else if(linkText.startsWith("//")){
			link=ElementUtil.findElementByXpath(linkText);
		}
		
		else if(linkText.startsWith("link")){
			link=ElementUtil.findElementByLinkText(linkText);
		}
		by=byOfLink;
		WebPage.elementList.put(link, linkText);
	}
	
	
	/**
	 * This method will click in the link passed as argument
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void click() throws IOException {
		Events.click(link);
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
