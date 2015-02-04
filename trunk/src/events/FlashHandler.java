package events;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pages.WebPage;

import exception.CFException;

import utils.Events;

public class FlashHandler /*implements FlashEvents */{
	private static WebDriver driver;
	private static String flashObjectId;
	private static Events events;

	public FlashHandler(final WebDriver webDriver, final String flashObjectId) {
		FlashHandler.driver = webDriver;
		FlashHandler.flashObjectId = flashObjectId;
		FlashHandler.events=new Events(webDriver);
	}
	
	public FlashHandler(final WebDriver webDriver, final String pageURL,final String flashObjectId) {
		FlashHandler.driver = webDriver;
		FlashHandler.flashObjectId = flashObjectId;
		events=new Events(webDriver);
		driver.get(pageURL);
	}
	
	/**
	 * This method will click on the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 * @throws CFException 
	 */
	public static void flashClick(String objectId) throws CFException {
		FlashHandler.callFlashObject(objectId);
		events.write("<b>Clicking the element "+WebPage.elementList.get(objectId));
	}
	/**
	 * This method will return the value in the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 */
	public static String getString(final String objectId){
		return callFlashObject("GetVariable/:",objectId);
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
		String temp="/:";
		callFlashObject("SetVariable",temp+objectId,string);
		events.write("<b>typing on the element "+WebPage.elementList.get(objectId));
	}
	
	
	private static String callFlashObject(final String functionName,
			final String... args) {
		final Object result = ((JavascriptExecutor)FlashHandler.driver).executeScript(
				makeJsFunction(functionName, args), new Object[0]);
		return result != null ? result.toString() : null;
	}

	private static String makeJsFunction(final String functionName,
			final String... args) {
		final StringBuffer functionArgs = new StringBuffer();
		
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				if (i > 0) {
					functionArgs.append(",");
				}
				functionArgs.append(String.format("'%1$s'", args[i]));
			}
		}
		return String.format("return document.%1$s.%2$s(%3$s);", flashObjectId,
				functionName, functionArgs);
	}

}