package reports;

import org.testng.Reporter;

public class Report {
	
	/**
	 * writes the log to report
	 * 
	 * @author Pradeep Sundaram
	 * @param logMessage
	 */
	public static void log(String logMessage){
		Reporter.log(logMessage);
	}
	
	/**
	 * writes the log to console
	 * 
	 *  @author Pradeep Sundaram
	 * @param logMessage
	 * @param toStandardOutput
	 */
	public static void log(String logMessage, boolean toStandardOutput){
		Reporter.log(logMessage+"<BR>",toStandardOutput);
	}
	
	/**
	 * @author Pradeep Sundaram
	 * @param logMessage
	 * @param level
	 */
	public static void log(String logMessage, int level){
		Reporter.log(logMessage+"<BR>",level);
	}
	
	/**
	 * 
	 * @author Pradeep Sundaram
	 * @param logMessage
	 * @param level
	 * @param toStandardOutput
	 */
	public static void log(String logMessage, int level, boolean toStandardOutput){
		Reporter.log(logMessage+"<BR>",level,toStandardOutput);
	}
	
}
