package pages;

import org.openqa.selenium.WebDriver;

import events.FlashHandler;
import exception.CFException;

public class FlashPage {
	private FlashHandler flashHandler=null;
	
	
	public FlashPage(final WebDriver webDriver, final String flashObjectId) {
		flashHandler=new FlashHandler(webDriver,flashObjectId);
	}
	
	/**
	 * This method will click on the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 * @throws CFException 
	 */
	public void flashClick(final String objectId) throws CFException {
		flashHandler.flashClick(objectId);
	}
	/**
	 * This method will return the value in the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 */
	public String getString(final String objectId){
		return flashHandler.getString(objectId);
	}
	
	/**
	 * This method will type in the element
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @param string
	 * @return
	 */
	public void typeString(final String objectId,String string)throws CFException{
		flashHandler.typeString(objectId,string);
	}
}
