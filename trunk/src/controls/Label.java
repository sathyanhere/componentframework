package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class Label {
	private By by;
	private WebElement lbl;
	
	/**
	 * Normal constructor
	 * @author Pradeep Sundaram
	 * @param label
	 * @param desc
	 */
	public Label(WebElement label, String desc) {
		lbl = label;
		WebPage.elementList.put(lbl, desc);
	}
	
	/**
	 * Constructor for Label when By of the label is required
	 * @author Pradeep Sundaram
	 * @param label
	 * @param byOfLabel
	 * @param desc
	 */
	public Label(WebElement label,By byOfLabel, String desc) {
		lbl = label;
		by=byOfLabel;
		WebPage.elementList.put(lbl, desc);
	}
	
	
	
	public Label(String label,String description){
		if(label.startsWith("//")){
			lbl=ElementUtil.findElementByXpath(label);
		}
		else if(label.startsWith("id")){
			lbl=ElementUtil.findElementByID(label);
		}
		WebPage.elementList.put(lbl, description);
	}
	
	public Label(String label,By byOfLabel, String description){
		if(label.startsWith("//")){
			lbl=ElementUtil.findElementByXpath(label);
		}
		by=byOfLabel;
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
		Report.log("Checking whether the field " + WebPage.elementList.get(lbl)+" is displayed.<BR>");
		return lbl.isDisplayed();
	}
}
