package controls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.WebPage;
import reports.Report;
import utils.Events;

public class SelectBox {
	private Select selectBox;
	private By by;

	public SelectBox(Select select, String desc) {
		selectBox = select;
		WebPage.elementList.put(selectBox, desc);
	}

	
	/**
	 * Constructor for select box when By of the select box is required
	 * 
	 * @author Pradeep Sundaram
	 * @param select
	 * @param byOfSelect
	 * @param desc
	 */
	public SelectBox(Select select, By byOfSelect, String desc) {
		selectBox = select;
		by = byOfSelect;
		WebPage.elementList.put(selectBox, desc);
	}

	/**
	 * This method select the text in drop down for the passed index
	 * 
	 * @author Pradeep Sundaram
	 * @param index
	 * @throws IOException
	 */
	public void select(int index) throws IOException {
		Events.select(selectBox, index);
	}

	
	public SelectBox(String textID,String fieldDesc){
		if(textID.startsWith("id")){
			selectBox=ElementUtil.findSelectByID(textID);
		}
		else if(textID.startsWith("name")){
			selectBox=ElementUtil.findSelectByName(textID);
		}
		else if(textID.startsWith("css")){
			selectBox=ElementUtil.findSelectByCss(textID);
		}
		else if(textID.startsWith("//")){
			selectBox=ElementUtil.findSelectByXpath(textID);
		}
		WebPage.elementList.put(selectBox, fieldDesc);
	}
	
	public SelectBox(String textID,By byOfTf,String fieldDesc){
		if(textID.startsWith("id")){
			selectBox=ElementUtil.findSelectByID(textID);
		}
		else if(textID.startsWith("name")){
			selectBox=ElementUtil.findSelectByName(textID);
		}
		else if(textID.startsWith("css")){
			selectBox=ElementUtil.findSelectByCss(textID);
		}
		else if(textID.startsWith("//")){
			selectBox=ElementUtil.findSelectByXpath(textID);
		}
		by=byOfTf;
		WebPage.elementList.put(selectBox, fieldDesc);
	}
	
	/**
	 * This method selects the text in drop down for the passed value
	 * 
	 * @author Pradeep Sundaram
	 * @param value
	 * @throws IOException
	 */
	public void selectByValue(String value) throws IOException {
		Events.selectByValue(selectBox, value);
	}

	/**
	 * This method selects the passed text in the drop down
	 * 
	 * @author Pradeep Sundaram
	 * @param selectString
	 * @throws IOException
	 */
	public void select(String selectString) throws IOException {
		Events.selectByText( selectBox, selectString);
	}

	public String getSelectedValue() {
		return selectBox.getFirstSelectedOption().getText();
	}

	/**
	 * This method will return By of the passed Select
	 * 
	 * @author Pradeep Sundaram
	 * @param elem
	 * @return
	 */
	public By getBy() {
		return by;
	}
	/**
	 * This method will return the select of the selectBox
	 * @author Pradeep Sundaram
	 * @return
	 */
	public Select getSelect(){
		return selectBox;
	}
	
	/**
	 * This method will return all the options in the select box
	 * @author Pradeep Sundaram
	 * @return
	 */
	public List<String> getOptions(){
		List<String> options=new ArrayList<String>();
		List<WebElement> list=selectBox.getOptions();
		int size=list.size();
		for(int i=0;i<size;i++){
			options.add(list.get(i).getText());
		}
		return options;
	}
	
	/**
	 * This method will return the webelement of the select box
	 * 
	 * @author Pradeep Sundaram.S
	 * @return WebElement
	 */
	public WebElement getWebElement(){
		return WebPage.driver.findElement(this.getBy());
	}
	
	
	/**
	 * will return boolean based on the presence of the select box
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the selectBox is displayed.<BR>");
      return WebPage.driver.findElement(by).isDisplayed();
	}
}
