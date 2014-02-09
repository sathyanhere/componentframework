package exception;

public class CFException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CFException(String trace){
		super(trace);
	}
}
