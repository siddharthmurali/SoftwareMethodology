package util;

public class SomeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SomeException(){
		super();
	}
	
	public SomeException(String message){
		super(message);
	}
	
	public SomeException(String message, Throwable cause){
		super(message, cause);
	}
	
	public SomeException(Throwable cause){
		super(cause);
	}
}
