package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.WebPage;
import reports.Report;

public class CheckBox {
	private WebElement checkBox;
	private By by;
//	private ElementUtil elementUtil;
	
	public CheckBox(String checkBoxName,String description){
		if(checkBoxName.startsWith("name")){
			by=ElementUtil.byName(checkBoxName);
		}
		else if(checkBoxName.startsWith("css")){
			by=ElementUtil.byCss(checkBoxName);
		}
		else if(checkBoxName.startsWith("//")){
			by=ElementUtil.byXpath(checkBoxName);
		}
		else if(checkBoxName.startsWith("id")){
			by=ElementUtil.byID(checkBoxName);
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
		checkBox=ElementUtil.findElement(by);
		ElementUtil.check(checkBox);
	}

	/**
	 * this method will uncheck the check box if it is checked, leaves it if the
	 * check box is not checked
	 * 
	 * @author Pradeep Sundaram
	 * @throws IOException
	 */
	public void unCheck() throws IOException {
		checkBox=ElementUtil.findElement(by);
		ElementUtil.unCheck(checkBox);
	}
	
	/**
	 * This method will return whether the Check box is checked in the page 
	 * @throws IOException
	 */
	public boolean isChecked() throws IOException {
		checkBox=ElementUtil.findElement(by);
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
		checkBox=ElementUtil.findElement(by);
		return checkBox;
	}
	
	
	/**
	 * will return boolean based on the presence of the check box
	 * 
	 * @author Pradeep Sundaram
	 * @return boolean
	 */
	public boolean isDisplayed() {
		checkBox=ElementUtil.findElement(by);
		Report.log("Checking whether the field \"" + WebPage.elementList.get(checkBox)+"\" is displayed.<BR>");
		return checkBox.isDisplayed();
	}
}
