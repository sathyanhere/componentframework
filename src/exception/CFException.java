package exception;

public class CFException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CFException(String trace){
		super(trace);
	}
}
