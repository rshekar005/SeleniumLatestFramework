package com.qa.Exceptions;

/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 * @author rajasekhar
 * 
 * @see com.qa.Exceptions.FrameWorkExceptions
 *
 */
public class PropertyFileUsageException extends FrameWorkExceptions{
	
	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public PropertyFileUsageException(String message) {
		super(message);	
	}
	
	/**
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public PropertyFileUsageException(String message, Throwable cause) {
		super(message,cause);
	}

}
