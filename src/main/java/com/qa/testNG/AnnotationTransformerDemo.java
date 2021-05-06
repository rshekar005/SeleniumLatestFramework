package com.qa.testNG;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/*
 * 1. Customization class
 * 2. Transform method will call each time
 * 3. testMethod will check for all @test methods present to execute
 */
public class AnnotationTransformerDemo implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		/*
		 * Here testMethod will check for test1 method in entire suite and it will set to false. So that test1() method will not get execute.
		 Here we are hardcorded we can set this at runtime
		 * if(testMethod.getName().equalsIgnoreCase("test1")) {
		 * annotation.setEnabled(false); }
		 */
		Map<String, Object> test1 = new HashMap<String, Object>();
		test1.put("name", "test1");
		test1.put("count", 5);
		test1.put("enabled", false);

		Map<String, Object> test2 = new HashMap<String, Object>();
		test1.put("name", "test2");
		test1.put("count", 3);
		test2.put("enabled", true);

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(test1);
		list.add(test2);
		
		for(int i=0;i<list.size();i++) {
			if(testMethod.getName().equalsIgnoreCase(String.valueOf(list.get(i).get("name")))) {
				if(list.get(i).get("enabled").equals("false")) {
					annotation.setEnabled(false);
				}
				else {
				//	annotation.setInvocationCount((Integer) list.get(i).get("count"));
					annotation.setRetryAnalyzer(Retry.class);
				}
				
			}
		}
		

	}

}
