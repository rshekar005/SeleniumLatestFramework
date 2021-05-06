package com.qa.testNG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

/*
     * This interface is used when we need to run only some certain methods at runtime which will come from excel sheet
	 * List contains all the test that testNG going to execute test1, test2, test3
	 * Methods reference holds all the test methods that needs to execute
	 * This method reference will call only once for the entire suite
	 */
public class MethodInterceptor implements IMethodInterceptor {

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		/* result.add(methods.get(0)); */

		Map<String, String> test1 = new HashMap<String, String>();
		test1.put("name", "test1");
		test1.put("count", "5");

		Map<String, String> test2 = new HashMap<String, String>();
		test1.put("name", "test2");
		test1.put("count", "3");

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list.add(test1);
		list.add(test2);

		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))) {
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
					result.add(methods.get(i));
				}
			}
		}
		return result;

	}

}
