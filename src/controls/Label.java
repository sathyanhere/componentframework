package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Label {
	private By by;
	private WebElement lbl;
	private ElementUtil elementUtil;
	
	public Label(String label,String description,ElementUtil util){
		elementUtil=util;
		if(label.startsWith("//")){
			by=util.byXpath(label);
		}
		else if(label.startsWith("id")){
			by=util.byID(label);
		}
		WebPage.elementList.put(lbl, description);
	}
	
	/**
	 * This method will return the content in the Label
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public String getText() {
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
	 * @return 
	 */
	public WebElement getWebElement() {
		return lbl;
	}
	
	/**
	 * will return boolean based on the presence of the label
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field \"" + WebPage.elementList.get(lbl)+"\" is displayed.<BR>");
		return lbl.isDisplayed();
	}
}
