/**
 * 
 */
package com.qa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.constants.FrameWorkConstants;
import com.qa.enums.ConfigProperty;

/**
 * To construct the map by the reading the config values from JSON. Not used in this framework but can be leveraged
 * instead of property file based on the requirements
 * @author rajasekhar
 *
 * @see com.qa.util.ConfigReader
 */
public  final class JsonUtils {
	
	private static Map<String, String> CONFIGMAP;

	/**
	 * Private constructor to avoid external instantiation
	 */
	private JsonUtils() {

	}

	static {
		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameWorkConstants.getJsonfilepath()), 
					new TypeReference<HashMap<String,String>>() {});
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperty key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
