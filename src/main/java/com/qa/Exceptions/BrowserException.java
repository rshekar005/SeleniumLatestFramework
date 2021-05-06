/**
 * 
 */
package com.qa.Exceptions;

/**
 * @author rajasekhar
 *
 */
@SuppressWarnings("serial")
public class BrowserException extends FrameWorkExceptions{

	/**
	 * @param message
	 */
	public BrowserException(String message) {
		super(message);
	}
	
	public BrowserException(String message,Throwable cause) {
		super(message,cause);
	}

}
