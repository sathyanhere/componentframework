package events;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public interface KeyEvents {
	
	public void pressEscKey();
	
	public void pressBackSpace();
	
	public void pressTabKey() ;
	
	public void keyDownAlt() ;
	
	public void pressShiftTabKey(int howManyTimes) ;
	
	public void pressTabKey(int howManyTimes) ;
	
	public void pressEnterKey();
	
	public void pressSpaceBar() ;
	
	public void type(String text) ;
	
	public void pressShiftKey();
	
	public void releaseShiftKey();
	
	public void pressCtrlKey();
	
	public void releaseCtrlKey();
	
	public void doubleClick(WebDriver driver,WebElement webElement);
	
	public void pressDownKey();
	
	public void releaseDownKey();
}
