package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReporter() {

		ExtentReports extentReports = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkExtent = new ExtentSparkReporter(extentReportFile);

		sparkExtent.config().setTheme(Theme.DARK);
		sparkExtent.config().setDocumentTitle("MyStore website");
		sparkExtent.config().setReportName("My Store");
		sparkExtent.config().setTimeStampFormat("dd//MM/YYYY hh:mm:ss");

		extentReports.attachReporter(sparkExtent);

		Properties configProp = new Properties();
		File configFile = new File(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties"); 

		try {
			FileInputStream fis = new FileInputStream(configFile);
			configProp.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		extentReports.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));

		
		extentReports.flush();
		
		return extentReports;

	}
}
