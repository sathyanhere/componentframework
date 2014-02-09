package controls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.WebPage;
import reports.Report;

public class SelectBox {
	private Select selectBox;
	private By by;
	private ElementUtil elementUtil;
		
	public SelectBox(String textID,String fieldDesc, ElementUtil util){
		elementUtil=util;
		if(textID.startsWith("id")){
			by=elementUtil.byID(textID);
		}
		else if(textID.startsWith("name")){
			by=elementUtil.byName(textID);
		}
		else if(textID.startsWith("css")){
			by=elementUtil.byCss(textID);
		}
		else if(textID.startsWith("//")){
			by=elementUtil.byXpath(textID);
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
	public void select(int index) throws IOException {
		selectBox=elementUtil.findSelect(by);
		elementUtil.select(selectBox, index);
	}

	
	/**
	 * This method selects the text in drop down for the passed value
	 * 
	 * @author Pradeep Sundaram
	 * @param value
	 * @throws IOException
	 */
	public void selectByValue(String value) throws IOException {
		selectBox=elementUtil.findSelect(by);
		elementUtil.selectByValue(selectBox, value);
	}

	/**
	 * This method selects the passed text in the drop down
	 * 
	 * @author Pradeep Sundaram
	 * @param selectString
	 * @throws IOException
	 */
	public void select(String selectString) throws IOException {
		selectBox=elementUtil.findSelect(by);
		elementUtil.selectByText(selectBox, selectString);
	}
	/**
	 * This method will return the selected value in the select box
	 * @return
	 */
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
		return elementUtil.findElement(by);
	}
	
	
	/**
	 * will return boolean based on the presence of the select box
	 * 
	 * @return boolean
	 */
	public boolean isDisplayed() {
		Report.log("Checking whether the field \"" + WebPage.elementList.get(selectBox)+"\" is enabled.<BR>");
      return elementUtil.findElement(by).isDisplayed();
	}
}
