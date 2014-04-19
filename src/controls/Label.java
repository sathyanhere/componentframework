package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Label {
	private By by;
	private WebElement lbl;
//	private ElementUtil elementUtil;
	
	public Label(String label,String description){
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
		WebPage.elementList.put(lbl, description);
	}
	
	/**
	 * This method will return the content in the Label
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 * 
	 */
	public String getText() {
		lbl=ElementUtil.findElement(by);
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
		lbl=ElementUtil.findElement(by);
		return lbl;
	}
	
	/**
	 * will return boolean based on the presence of the label
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		lbl=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(lbl)+"\" is displayed.<BR>");
		return lbl.isDisplayed();
	}
}
