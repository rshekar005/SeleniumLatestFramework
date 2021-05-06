package com.qa.Exceptions;

/**
 * BaseException for the framework. Extends Runtime Exception and can be thrown
 * anywhere to terminate a progra
 * 
 * @author rajasekhar
 *
 */
public class FrameWorkExceptions extends RuntimeException {

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public FrameWorkExceptions(String message) {
		super(message);
	}

	/**
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public FrameWorkExceptions(String message, Throwable cause) {
		super(message, cause);
	}

}
