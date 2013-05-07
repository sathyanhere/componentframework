package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.WebPage;
import reports.Report;


public class Events {
	private static WebElement element;
	private static Select select;
	private static String ScreenShotInitial="<a href=\"./screenshot/";
	private static String ScreenShotEnd=".png\"  target=\"_blank\"> SCREEN SHOT </a> \n";
	private static Integer counter=1;
	
	/**
	 * This method will click in the webElement passed as argument 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws IOException 
	 */
	public static void click(WebElement webElement) throws IOException {
		element=webElement;
		element.click();
		write("<b>Clicking the element "+WebPage.elementList.get(element),counter++);
	}
	
	/**
	 * This method will type the text in webElement passed as arguments
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @param text
	 * @throws IOException 
	 */
	public static void type(WebElement webElement, String text) throws IOException {
		element=webElement;
		element.clear();
		element.sendKeys(text);
		write("<b>Typing \'"+text+"\' in "+WebPage.elementList.get(element), counter++);
	}
	
	
	/**
	 * This method select the text in drop down for the passed index
	 * 
	 * @author Pradeep Sundaram
	 * @param selectField
	 * @param index
	 * @throws IOException
	 */
	public static void select(Select selectField,
			int index) throws IOException {
		select=selectField;
		select.selectByIndex(index);
		write("<b>Selecting the " + index + "th element in "
				+ WebPage.elementList.get(select), counter++);
	}

	/**
	 * This method selects the text in drop down for the passed value
	 * 
	 * @author Pradeep Sundaram
	 * @param selectField
	 * @param value
	 * @throws IOException
	 */
	public static void selectByValue(Select selectField, String value) throws IOException {
		select=selectField;
		select.selectByValue(value);
		write("<b>Selecting \'" + value + "\' in "+WebPage.elementList.get(select), counter++);
	}

	/**
	 * This method selects the passed text in the drop down
	 * 
	 * @author Pradeep Sundaram
	 * @param selectField
	 * @param selectString
	 * @throws IOException
	 */
	public static void selectByText(Select selectField,
			String selectString) throws IOException {
		select=selectField;
		select.selectByVisibleText(selectString);
		write("<b>Selecting \'" + selectString + "\' in "+ WebPage.elementList.get(select), counter++);
	}
	
	/**
	 * This method will check the check box if it is unchecked
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @param text
	 * @throws IOException
	 */
	public static void check(WebElement webElement)
			throws IOException {
		element = webElement;
		if (!element.isSelected()) { //checks whether check box is unchecked
			element.click();
		}
		write("<b>Checking \'"+ WebPage.elementList.get(webElement), counter++);
	}
    
	
	 /**
	  * this method will uncheck the check box if it is checked, leaves it if the check 
	  * box is not checked
	  * @author Pradeep Sundaram
	  * @param webElement
	  * @param text
	  * @throws IOException
	  */
	public static void unCheck(WebElement webElement)
			throws IOException {
		element = webElement;
		if (element.isSelected()) { // checks whether check box is checked
			element.click();
		}
		write("<b>Un Checking \'"+ WebPage.elementList.get(webElement), counter++);
	}
	
	/**
	 * This method will write trace and take screen shot and put the screen shot in the destination location and link the screen shot with the report
	 * 
	 * @author Pradeep Sundaram
	 * @param logMessage
	 * @param counter
	 * @throws IOException
	 */
	public static void write(String logMessage,Integer counter) throws IOException{
		String hyperLink=ScreenShotInitial+counter+ScreenShotEnd;
		String message=logMessage+hyperLink+"<BR>";
		Report.log(message);
		File directory = new File (".");
		String path=directory.getCanonicalPath()+"\\test-output\\screenshot\\";
		File f=new File(path+counter+".png");
//		File f=new File(WebPage.reportFilePath+counter+".png");
		File scrFile = ((TakesScreenshot)WebPage.driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(scrFile, f);
		counter++;
	}
	
	/**
	 * This method will choose the radio button
	 * 
	 * @author Pradeep Sundaram
	 * @param webElement
	 * @throws IOException
	 */
	public static void choose(WebElement webElement)
			throws IOException {
		element = webElement;
		if (!element.isSelected()) {// checks whether check box is unchecked
			element.click();
		}
		else{
			Report.log("the radio button is already selected<BR>");	
		}
		write("<b>Choosing \'" + WebPage.elementList.get(webElement),
				counter++);
	}
}
