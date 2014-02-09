package reports;

import org.testng.Reporter;

public enum LogHelper {
	
	Logger;
	 
	public void log(String logMessage) {
		Reporter.log(logMessage+"<BR>");
	}
	
	public void log(String logMessage, boolean toStandardOutput){
		Reporter.log(logMessage+"<BR>",toStandardOutput);
	}
	
}
