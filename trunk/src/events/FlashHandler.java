package events;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pages.WebPage;

import exception.CFException;

import utils.Events;

public class FlashHandler implements FlashEvents {
	private final WebDriver webDriver;
	private final String flashObjectId;
	private Events events;

	public FlashHandler(final WebDriver webDriver, final String flashObjectId) {
		this.webDriver = webDriver;
		this.flashObjectId = flashObjectId;
		this.events=new Events(webDriver);
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
		callFlashObject(objectId);
		events.write("<b>Clicking the element "+WebPage.elementList.get(objectId));
	}
	/**
	 * This method will return the value in the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 */
	public String getString(final String objectId){
		String temp="/:";
		return callFlashObject("GetVariable",temp+objectId);
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
		String temp="/:";
		callFlashObject("SetVariable",temp+objectId,string);
		events.write("<b>typing on the element "+WebPage.elementList.get(objectId));
	}
	
	
	private String callFlashObject(final String functionName,
			final String... args) {
		final Object result = ((JavascriptExecutor) webDriver).executeScript(
				makeJsFunction(functionName, args), new Object[0]);
		return result != null ? result.toString() : null;
	}

	private String makeJsFunction(final String functionName,
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