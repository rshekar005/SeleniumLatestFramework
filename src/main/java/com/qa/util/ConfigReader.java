package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.qa.Exceptions.InvalidPathException;
import com.qa.Exceptions.PropertyFileUsageException;
import com.qa.constants.FrameWorkConstants;
import com.qa.enums.ConfigProperty;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 * @author rajasekhar
 *
 */
public final class ConfigReader {
	private ConfigReader() {
	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP= new HashMap<String, String>();
	
	static {
		try(FileInputStream fis = new FileInputStream(FrameWorkConstants.getPropertyfilepath())) {
			prop.load(fis);
			for(Map.Entry<Object, Object> entry : prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Receives the {@link com.qa.enums.ConfigProperty},converts to lowercase , return the corresponding value
	 * for the key from the HashMap
	 * @author rajasekhar
	 * @param key To be fetched from property file
	 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
	 */
	public static String getValue(ConfigProperty key) {
		if(Objects.isNull(key.name()) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException("Property name " + key +" is not found. Please check config.properties"); 
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

	
	 
	 

}
