package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class CheckBox {
	private WebElement checkBox;
	private By by;
	
	
	public CheckBox(WebElement checkBoxName, String description) {
		checkBox = checkBoxName;
		WebPage.elementList.put(checkBox, description);
	}
	/**
	 * Constructor for Check Box when By of the check box is required
	 * @author Pradeep Sundaram
	 * @param checkBoxName
	 * @param byOfCheckBox
	 * @param description
	 */
	public CheckBox(WebElement checkBoxName,By byOfCheckBox, String description) {
		checkBox = checkBoxName;
		by=byOfCheckBox;
		WebPage.elementList.put(checkBox, description);
	}
	
	
	public CheckBox(String checkBoxName,String description){
		if(checkBoxName.startsWith("name")){
			checkBox=ElementUtil.findElementByName(checkBoxName);
		}
		else if(checkBoxName.startsWith("css")){
			checkBox=ElementUtil.findElementByCss(checkBoxName);
		}
		else if(checkBoxName.startsWith("//")){
			checkBox=ElementUtil.findElementByXpath(checkBoxName);
		}
		else if(checkBoxName.startsWith("id")){
			checkBox=ElementUtil.findElementByID(checkBoxName);
		}
		else{
			Report.log("button is not found");
		}
		WebPage.elementList.put(checkBox, description);
	}
	
	public CheckBox(String checkBoxName,By byOfCheckBox,String description){
		if(checkBoxName.startsWith("name")){
			checkBox=ElementUtil.findElementByName(checkBoxName);
		}
		else if(checkBoxName.startsWith("css")){
			checkBox=ElementUtil.findElementByCss(checkBoxName);
		}
		else if(checkBoxName.startsWith("//")){
			checkBox=ElementUtil.findElementByXpath(checkBoxName);
		}
		else if(checkBoxName.startsWith("id")){
			checkBox=ElementUtil.findElementByID(checkBoxName);
		}
		else{
			Report.log("button is not found");
		}
		by=byOfCheckBox;
		WebPage.elementList.put(checkBox, description);
	}
	
	/**
	 * This method will check the check box if it is unchecked
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void check() throws IOException {
		Events.check(checkBox);

	}

	/**
	 * this method will uncheck the check box if it is checked, leaves it if the
	 * check box is not checked
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void unCheck() throws IOException {
		Events.unCheck(checkBox);
	}
	
	/**
	 * This method will return whether the Check box is checked in the page 
	 * @throws IOException
	 */
	public boolean isChecked() throws IOException {
		return checkBox.isSelected();
	}
	
	
	/**
	 * This method will return the By for the Check Box
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}
	
	/**
	 * This method will return the webelement of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return
	 */
	public WebElement getWebElement(){
		return checkBox;
	}
	
	
	/**
	 * will return boolean based on the presence of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field " + WebPage.elementList.get(checkBox)+" is displayed.<BR>");
		return checkBox.isDisplayed();
	}
}
