package com.qa.util;

import java.util.Base64;

/**
 * Helps to decode the base64 encoded string.
 * @author rajasekhar
 *
 */
public final class DecodeUtils {
	private DecodeUtils() {}
	
	/**
	 * Accepts and base64 string,decode and return to the caller
	 * @author rajasekhar
	 * @param encodedString Base64 encoded string
	 * @return String  Decoded base64 string
	 */
	public static String getDecoderString(String encodedString) {
		return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}
}
