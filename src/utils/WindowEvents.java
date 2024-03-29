package utils;

import org.openqa.selenium.WebDriver;

public interface WindowEvents {
	
	public void selectFrame(WebDriver driver, String frameName);

	public void selectWindow(WebDriver driver, String windowName);
	
	public void switchToMainPage(WebDriver driver);
	
}
