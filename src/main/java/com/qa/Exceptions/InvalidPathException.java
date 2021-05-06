package com.qa.Exceptions;

/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 * @author rajasekhar
 * 
 * @see com.qa.Exceptions.FrameWorkExceptions
 *
 */
public class InvalidPathException extends FrameWorkExceptions{
	
	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public InvalidPathException(String message) {
		super(message);	
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidPathException(String message, Throwable cause) {
		super(message,cause);
	}

}
