package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Link {
	private WebElement link;
	private By by;
//	private String linkName;
	private String linkDesc;
//	private ElementUtil elementUtil;
	

	public Link(String linkText,String desc){
		linkDesc=desc;
		if(linkText.startsWith("id")){
			by=ElementUtil.byID(linkText);
		}
		
		else if(linkText.startsWith("css")){
			by=ElementUtil.byCss(linkText);
		}
		
		else if(linkText.startsWith("//")|| linkText.startsWith("(")){
			by=ElementUtil.byXpath(linkText);
		}
		
		else if(linkText.startsWith("link")){
			by=ElementUtil.byLinkText(linkText);
		}
		
	}
	
	public Link(WebElement webElement,String desc){
		link=webElement;
		linkDesc=desc;
		
	}
	
	
	public Link(String linkText){
		link=ElementUtil.findElementByLinkText(linkText);
		WebPage.elementList.put(link, linkText);
	}
	
	/**
	 * This method will click in the link passed as argument
	 * 
	 * @author Pradeep Sundaram
	 */
	public void click(){
		if(by!=null){
			link=ElementUtil.findElement(by);	
		}
		WebPage.elementList.put(link, linkDesc);
		ElementUtil.click(link);
	}
	
	/**
	 * This method will return the By for the button
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the text displayed in the text
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 */
	public String getText(){
		if(by!=null){
			link=ElementUtil.findElement(by);	
		}
		WebPage.elementList.put(link, linkDesc);
		return link.getText();
	}
	/**
	 * This method will return the webelement of the link
	 * @author Pradeep Sundaram
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		if(by!=null){
			link=ElementUtil.findElement(by);	
		}
		WebPage.elementList.put(link, linkDesc);
		return link;
	}
	
	
	/**
	 * will return boolean based on the presence of the link
	 * 
	 * @author Pradeep Sundaram 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		if(by!=null){
			link=ElementUtil.findElement(by);	
		}
		WebPage.elementList.put(link, linkDesc);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(link)+"\" is displayed.<BR>");
		return link.isDisplayed();
	}
	
	/**
	 * Right click the link
	 * 
	 * @author Pradeep Sundaram
	 */
	public void rightClick() {
		if (by != null) {
			link = ElementUtil.findElement(by);
		}
		WebPage.elementList.put(link, linkDesc);
		ElementUtil.rightClick(link);
	}
}
