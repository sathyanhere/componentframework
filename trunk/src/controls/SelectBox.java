package controls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.WebPage;
import reports.Report;
import exception.CFException;

public class SelectBox {
	private Select selectBox;
	private By by;
//	private ElementUtil elementUtil;
		
	public SelectBox(String textID,String fieldDesc){
		if(textID.startsWith("id")){
			by=ElementUtil.byID(textID);
		}
		else if(textID.startsWith("name")){
			by=ElementUtil.byName(textID);
		}
		else if(textID.startsWith("css")){
			by=ElementUtil.byCss(textID);
		}
		else if(textID.startsWith("//")|| textID.startsWith("(")){
			by=ElementUtil.byXpath(textID);
		}
		WebPage.elementList.put(selectBox, fieldDesc);
	}
	
	/**
	 * This method select the text in drop down for the passed index
	 * 
	 * @author Pradeep Sundaram
	 * @param index
	 * @throws IOException
	 */
	public void select(int index){
		if (by != null) {
			selectBox=ElementUtil.findSelect(by);			
		}
		try {
			ElementUtil.select(selectBox, index);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * This method selects the text in drop down for the passed value
	 * 
	 * @author Pradeep Sundaram
	 * @param value
	 */
	public void selectByValue(String value){
		if (by != null) {
			selectBox=ElementUtil.findSelect(by);			
		}
		try {
			ElementUtil.selectByValue(selectBox, value);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method selects the passed text in the drop down
	 * 
	 * @author Pradeep Sundaram
	 * @param selectString
	 */
	public void select(String selectString)  {
		if (by != null) {
			selectBox=ElementUtil.findSelect(by);			
		}
		try {
			ElementUtil.selectByText(selectBox, selectString);
		} catch (CFException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will return the selected value in the select box
	 * 
	 * @author Pradeep Sundaram
	 * @return String
	 */
	public String getSelectedValue() {
		if (by != null) {
			selectBox=ElementUtil.findSelect(by);			
		}
		return selectBox.getFirstSelectedOption().getText();
	}

	/**
	 * This method will return By of the passed Select
	 * 
	 * @author Pradeep Sundaram
	 * @return By
	 */
	public By getBy() {
		return by;
	}
	/**
	 * This method will return the select of the selectBox
	 * 
	 * @author Pradeep Sundaram
	 * @return Select
	 */
	public Select getSelect(){
		if (by != null) {
			selectBox=ElementUtil.findSelect(by);			
		}
		return selectBox;
	}
	
	/**
	 * This method will return all the options in the select box
	 * 
	 * @author Pradeep Sundaram
	 * @return List
	 */
	public List<String> getOptions(){
		if (by != null) {
			selectBox=ElementUtil.findSelect(by);	
		}
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
		return ElementUtil.findElement(by);
	}
	
	
	/**
	 * will return boolean based on the presence of the select box
	 * 
	 * @author Pradeep Sundaram S
	 * @return boolean
	 */
	public boolean isDisplayed() {
		if (by != null) {
			selectBox=ElementUtil.findSelect(by);	
		}
		Report.log("Checking whether the field \"" + WebPage.elementList.get(selectBox)+"\" is enabled.<BR>");
      return ElementUtil.findElement(by).isDisplayed();
	}
}
