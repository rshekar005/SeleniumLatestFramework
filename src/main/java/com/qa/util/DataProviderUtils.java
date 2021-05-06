package com.qa.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.qa.constants.FrameWorkConstants;
/**
 * Holds the data provider for all the test cases in the framework.
 * @author rajasekhar
 *
 */
public final class DataProviderUtils {
	
	private static List<Map<String, String>> list= new ArrayList<Map<String,String>>();
	
	/**
	 *
	 * Acts as a data provider for all the test cases.
	 * Parallel=true indicates that each of the iteration will be ran in parallel.
	 * 
	 * @author rajasekhar
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 *  
	 * 
	 * @see com.qa.tests.AmazonPageTest 
	 * @see com.qa.listener.AnnotationTransformer
	 */
	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {	
		String testName = m.getName();
		
		/*If list(Excelsheet) is not opened then it will open and will not close util the complete suite execute.
		  If below code is not written then each time for every test excel sheet gets opened and closed
		  To overcome we have written below code*/
		if(list.isEmpty()) {
			list=ExcelUtils.getTestDataLists(FrameWorkConstants.getIterationsheet());
		}
		List<Map<String, String>> smalllist= new ArrayList<Map<String,String>>();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testName) &&
				list.get(i).get("execute").equalsIgnoreCase("yes")) {
					smalllist.add(list.get(i));
			}
		}
		
		/* This line is used to remove tesdata from Map if it executed already
		 * Suppose test sheet contains 100 test cases.
		 * Running 100 test cases with test data.
		 * After executing one by one test case. It will remove that iteration from excelsheet.
		 * It means for next case it will not check for first test case. It will check remaining test cases.
		   list.removeAll(smalllist);
		*/
		return smalllist.toArray();
	}

}
