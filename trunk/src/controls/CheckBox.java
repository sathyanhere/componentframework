package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class CheckBox {
	private WebElement checkBox;
	private By by;
	private ElementUtil elementUtil;
	
	public CheckBox(String checkBoxName,String description,ElementUtil util){
		elementUtil=util;
		if(checkBoxName.startsWith("name")){
			by=util.byName(checkBoxName);
		}
		else if(checkBoxName.startsWith("css")){
			by=util.byCss(checkBoxName);
		}
		else if(checkBoxName.startsWith("//")){
			by=util.byXpath(checkBoxName);
		}
		else if(checkBoxName.startsWith("id")){
			by=util.byID(checkBoxName);
		}
		else{
			Report.log("button is not found");
		}
		WebPage.elementList.put(checkBox, description);
	}
	
	/**
	 * This method will check the check box if it is unchecked
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void check() throws IOException {
		checkBox=elementUtil.findElement(by);
		elementUtil.check(checkBox);
	}

	/**
	 * this method will uncheck the check box if it is checked, leaves it if the
	 * check box is not checked
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void unCheck() throws IOException {
		checkBox=elementUtil.findElement(by);
		elementUtil.unCheck(checkBox);
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
		Report.log("Checking whether the field \"" + WebPage.elementList.get(checkBox)+"\" is displayed.<BR>");
		return checkBox.isDisplayed();
	}
}
