package utils;

import java.awt.AWTException;

public interface KeyEvents {
	
	public void pressEscKey()throws AWTException;
	
	public void pressBackSpace()throws AWTException;
	
	public void pressTabKey() throws AWTException;
	
	public void pressShiftTabKey(int howManyTimes) throws AWTException;
	
	public void pressTabKey(int howManyTimes) throws AWTException;
	
	public void pressEnterKey()throws AWTException;
	
	public void pressSpaceBar() throws AWTException;
	
	public void type(String text) throws AWTException;
}
