package events;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import exception.CFException;

public class TestTestPlan {

	@Test
	public static void display() throws InterruptedException, CFException {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.permadi.com/tutorial/flashjscommand/");
		driver.manage().window().maximize();
		FlashHandler flashApp = new FlashHandler(driver,"myFlashMovie");
		flashApp.flashClick("Play");
		Thread.sleep(2000);
		flashApp.flashClick("StopPlay");
		Thread.sleep(2000);
		flashApp.flashClick("Rewind");
		Thread.sleep(2000);
		System.out.println(flashApp.getString("message"));
		flashApp.typeString("message","String to be typed");
		Thread.sleep(2000);
		System.out.println(flashApp.getString("message"));
		driver.quit();
	}

}
