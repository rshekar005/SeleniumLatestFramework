package com.qa.constants;

import com.qa.enums.ConfigProperty;
import com.qa.util.ConfigReader;
/**
 * Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files
 * 
 * @author rajasekhar
 *
 */
public final class FrameWorkConstants {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameWorkConstants() {
	}
	private static final String RESOURCESPATH=System.getProperty("user.dir")+ "/src/test/resources";
	private static final String CHROMEDRIVERPATH =RESOURCESPATH+ "/executables/chromedriver.exe";
	private static final String FIREFOXDRIVERPATH =RESOURCESPATH+ "/executables/geckodriver.exe";
	private static final String PROPERTYFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static final String JSONFILEPATH = RESOURCESPATH+"/config/config.json";
	private static final int EXPLICITWAIT = 10;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath="";
	private static final String EXCELPATH = System.getProperty("user.dir")+"/Excel/TestData.xlsx";
	private static final String RUNMANAGERSHEET="RunManager";
	private static final String ITERATIONSHEET="DATA";

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}
	
	public static String getJsonfilepath() {
		return JSONFILEPATH;
	}

	public static String getIterationsheet() {
		return ITERATIONSHEET;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	/**
	 * 
	 * @author rajasekhar
	 *  @return Extent Report path where the index.html file will be generated.
	 */
	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	/**
	 * 
	 * @author rajasekhar
	 * @return  If Override reports value in the 
	 * property file is no,then the timestamp will be appended
	 */
	private static String createReportPath()  {
		if(ConfigReader.getValue(ConfigProperty.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}

	public static void setExtentReportFilePath(String extentReportFilePath) {
		FrameWorkConstants.extentReportFilePath = extentReportFilePath;
	}

	public static String getExtentreportfolderpath() {
		return EXTENTREPORTFOLDERPATH;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	public static String getFirefoxdriverpath() {
		return FIREFOXDRIVERPATH;
	}
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getResourcespath() {
		return RESOURCESPATH;
	}

	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}


}
