package pages;

import org.openqa.selenium.WebDriver;

import events.FlashHandler;
import exception.CFException;

public class FlashPage {
	private static FlashHandler flashHandler=null;
	
	
	public FlashPage(final WebDriver webDriver, final String flashObjectId) {
		flashHandler=new FlashHandler(webDriver,flashObjectId);
	}
	
	
	public FlashPage(final WebDriver webDriver, String pageURL, final String flashObjectId) {
		flashHandler=new FlashHandler(webDriver,pageURL,flashObjectId);
//		webDriver.get(pageURL);
	}
	
	
	/**
	 * This method will click on the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 * @throws CFException 
	 */
	public static void flashClick(final String objectId) throws CFException {
//		WebPage.elementList.put(arg0, arg1)
		FlashHandler.flashClick(objectId);
	}
	/**
	 * This method will return the value in the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 */
	public static String getString(final String objectId){
		return FlashHandler.getString(objectId);
	}
	
	/**
	 * This method will type in the element
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @param string
	 * @return
	 */
	public static void typeString(final String objectId,String string)throws CFException{
		FlashHandler.typeString(objectId,string);
	}
}
