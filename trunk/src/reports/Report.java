package reports;


public class Report {
	
	/**
	 * writes the mesage to report
	 * 
	 * @author Pradeep Sundaram
	 * @param logMessage
	 */
	public static void log(String logMessage){
		LogHelper.Logger.log(logMessage);
		
	}
	
	/**
	 * writes the message to console
	 * 
	 *  @author Pradeep Sundaram
	 * @param logMessage
	 * @param toStandardOutput
	 */
	public static void log(String logMessage, boolean toStandardOutput){
		LogHelper.Logger.log(logMessage,toStandardOutput);
	}
	
}
