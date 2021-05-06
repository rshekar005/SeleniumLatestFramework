package com.qa.enums;

/**
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.
 * 
 * @author rajasekhar
 * @see com.qa.util.ConfigReader
 */
public enum ConfigProperty {
	URL,
	BROWSER,
	OVERRIDEREPORTS,
	PASSEDSTEPSCREENSHOTS,
	FAILEDSTEPSSCREENSHOTS,
	SKIPPEDSTEPSSCREENSHOTS,
	RETRYFAILEDTESTS,
	SENDRESULTSTOELK,
	SELENIUMGRIDURL,
	ELASTICURL,
	RUNMODE;
}
