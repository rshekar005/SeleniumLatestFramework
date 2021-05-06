package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.Exceptions.FrameWorkExceptions;
import com.qa.Exceptions.InvalidPathException;
import com.qa.constants.FrameWorkConstants;

/**
 * 
 * Utility class to read or write to excel.
 * 
 * @author rajasekhar
 * @see com.qa.listener.MethodInterceptor
 * @see DataProviderUtils
 */
public final class ExcelUtils {
	private ExcelUtils() {
	}
	
	/**
	 * Encapsulates all the value from the mentioned excel sheet and store it in
	 * List holding HashMaps. Key for the map in the column header in the excel sheet.
	 * 
	 * @author rajasekhar
	 * @param sheetname Excel sheetname to read the value from
	 * @return List where each index holds a map and Each map holds the details about the test
	 * TODO create reusable methods
	 */
	public static List<Map<String, String>> getTestDataLists(String sheetname) {
		List<Map<String, String>> list = null;
		try (FileInputStream fis = new FileInputStream(FrameWorkConstants.getExcelpath())) {
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int lastrownum = sheet.getLastRowNum();
			int lastcolumnnum = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			list = new ArrayList<Map<String, String>>();
			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap<String, String>();
				for (int j = 0; j < lastcolumnnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidPathException("Excel file trying to read is not found");
		} catch (IOException e) {
			throw new FrameWorkExceptions("some io exception happened while reading data from excel");
		}
		return list;

	}

}
