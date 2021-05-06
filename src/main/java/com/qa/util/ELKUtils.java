/**
 * 
 */
package com.qa.util;



import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.qa.enums.ConfigProperty;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


/**
 * @author rajasekhar
 *
 */
public final class ELKUtils {
	private ELKUtils() {};
	
	public static void sendELKData(String testCase, String status) {
		
		if(ConfigReader.getValue(ConfigProperty.SENDRESULTSTOELK).equalsIgnoreCase("yes")) {
			Map<String,String> map= new HashMap<String, String>();
			map.put("testName", testCase);
			map.put("status", status);
			map.put("executionTime", LocalDateTime.now().toString());
			
			Response response=given().header("Content-Type", "application/json")
					.log().all()
					.body(map)
					.post(ConfigReader.getValue(ConfigProperty.ELASTICURL));
			response.prettyPrint();
		}
		
		
	}

}
