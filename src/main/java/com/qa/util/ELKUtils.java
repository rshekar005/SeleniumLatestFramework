package com.qa.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.qa.enums.ConfigProperty;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * <h1>ELKUtils</h1>
 * <p>
 * The ELKUtils class provides utility methods for sending test execution data to an Elasticsearch, Logstash, and Kibana (ELK) stack.
 * It encapsulates the functionality to format test results and transmit them to a specified ELK endpoint.
 * </p>
 *
 * <p>
 * The class is designed to be used for reporting test outcomes in a centralized logging and monitoring system,
 * allowing for better tracking and analysis of test runs.
 * </p>
 *
 * @author rajasekhar
 */
public final class ELKUtils {

	/**
	 * Private constructor to prevent instantiation of this utility class.
	 */
	private ELKUtils() {
	}

	/**
	 * Sends test execution data to the ELK stack.
	 * <p>
	 * This method constructs a map containing the test case name, status, and execution timestamp,
	 * and then sends this data as a JSON payload to the ELK endpoint specified in the configuration.
	 * The sending of data is controlled by the {@link ConfigProperty#SENDRESULTSTOELK} configuration property.
	 * </p>
	 *
	 * @param testCase The name of the test case.
	 * @param status   The status of the test case (e.g., "pass", "fail").
	 */
	public static void sendELKData(String testCase, String status) {
		if (ConfigReader.getValue(ConfigProperty.SENDRESULTSTOELK).equalsIgnoreCase("yes")) {
			Map<String, String> map = new HashMap<>();
			map.put("testName", testCase);
			map.put("status", status);
			map.put("executionTime", LocalDateTime.now().toString());

			Response response = given()
					.header("Content-Type", "application/json")
					.log().all()
					.body(map)
					.post(ConfigReader.getValue(ConfigProperty.ELASTICURL));
			response.prettyPrint();
		}
	}
}