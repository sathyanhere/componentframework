package events;

import org.openqa.selenium.WebElement;

import exception.CFException;

public interface MouseEvents {
	
	public void mouseOver(WebElement webElement) throws CFException ;
	
	public void doubleClick(WebElement webElement) throws CFException ;
}
