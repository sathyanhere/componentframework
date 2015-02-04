package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Label {
	private By by;
	private WebElement lbl;
	private String desc;
//	private ElementUtil elementUtil;
	
	
	public Label(String label,String description){
		desc=description;
		if(label.startsWith("id")){
			by=ElementUtil.byID(label);
		}
		else if(label.startsWith("name")){
			by=ElementUtil.byName(label);
		}
		else if(label.startsWith("css")){
			by=ElementUtil.byCss(label);
		}
		else if(label.startsWith("//")|| label.startsWith("(")){
			by=ElementUtil.byXpath(label);
		}
		lbl=ElementUtil.findElement(by);
		WebPage.elementList.put(lbl, desc);
	}
	
	/**
	 * This constructor is used occasionally when webelement is known
	 * 
	 * @author Pradeep Sundaram
	 * @param label
	 * @param description
	 */
	public Label(WebElement label,String description){
		lbl=label;
		desc=description;
	}
	
	
	/**
	 * This method will return the content in the Label
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 * 
	 */
	public String getText() {
		if(by!=null){
			lbl=ElementUtil.findElement(by);	
		}
		return lbl.getText();
	}
	
	/**
	 * This method will return the By of the label
	 * @author Pradeep Sundaram
	 * @return
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webElement of the label
	 * @author Pradeep Sundaram
	 * @return  WebElement
	 */
	public WebElement getWebElement() {
		if (by != null) {
			lbl = ElementUtil.findElement(by);
		}
		return lbl;	
	}
	
	/**
	 * will return boolean based on the presence of the label
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		if(by!=null){
			lbl=ElementUtil.findElement(by);	
		}
		Report.log("Checking whether the field \"" + WebPage.elementList.get(lbl)+"\" is displayed.<BR>");
		return lbl.isDisplayed();
	}
	
	/**
	 * Right clicks the label
	 * 
	 * @author Pradeep Sundaram
	 */
	public void rightClick() {
		if (by != null) {
			lbl = ElementUtil.findElement(by);
		}
		WebPage.elementList.put(lbl, desc);
		ElementUtil.rightClick(lbl);
	}

}
