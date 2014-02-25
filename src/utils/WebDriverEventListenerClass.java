package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import reports.Report;

public class WebDriverEventListenerClass extends AbstractWebDriverEventListener{
	private static String ScreenShotInitial="<a href=\"./screenshot/";
	private static String ScreenShotEnd=".png\"  target=\"_blank\"> SCREEN SHOT </a> \n";
	
	public void onException(Throwable throwable, WebDriver driver) {
		try {
			File directory = new File(".");
			String path = directory.getCanonicalPath()+ "\\test-output\\screenshot";
			File f=new File(path + "\\failure.png");
        	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, f);
			String hyperLink=ScreenShotInitial+"failure"+ScreenShotEnd;
			Report.log("\""+throwable.getClass().toString()+"\" error in this page "+hyperLink+"<BR>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }

}
