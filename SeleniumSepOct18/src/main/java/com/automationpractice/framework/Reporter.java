package com.automationpractice.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {
	
	private static ExtentReports extentReposrts;
	
	
	static{
		extentReposrts = new ExtentReports();
		extentReposrts.attachReporter(new ExtentHtmlReporter("test-output/automation-report.html"));
	}
	
	private Reporter() {
		
	}
	
	public static ExtentReports getInstance() {
		return extentReposrts;
	}
	
	
	public static void saveReport() {
		extentReposrts.flush();
	}
	
	

}
