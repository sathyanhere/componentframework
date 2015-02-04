package controls;

import pages.WebPage;
import events.FlashHandler;
import exception.CFException;

public class FlashControl {
	
	private String controlID;
	private String controlDesc;
	
	public FlashControl(String buttonID, String buttonDesc) {
		this.controlID=buttonID;
		this.controlDesc=buttonDesc;
		WebPage.elementList.put(buttonID, buttonDesc);
	}
	
	/**
	 * This method will click on the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 * @throws CFException 
	 */
	public void flashClick(/*final String objectId*/) throws CFException {
		FlashHandler.flashClick(controlID);
	}
	/**
	 * This method will return the value in the element whose ID is passed
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @return
	 */
	public String getString(/*final String objectId*/){
		return FlashHandler.getString(controlID);
	}
	
	/**
	 * This method will type in the element
	 * 
	 * @author Pradeep Sundaram
	 * @param objectId
	 * @param string
	 * @return
	 */
	public void typeString(/*final String objectId,*/String string)throws CFException{
		FlashHandler.typeString(controlID,string);
	}
}
