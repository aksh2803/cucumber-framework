package org.advancedautomation.reportgeneration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	static ExtentReports extent;
	static ExtentTest extenttest;

	// Method for start report
	public static void startReport() {
		System.out.println("111");
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter("C:\\Users\\Akshaya.b\\git\\cucumber-framework\\src\\test\\resources\\ReportGeneration\\TestResults.html");
		System.out.println("222");
		extent = new ExtentReports();
		System.out.println("333");
		extent.attachReporter(extentsparkreporter);
		System.out.println("444");
	}

	// Method for close report
	public static void stopReport() {
		extent.flush();
	}

	// Method for creating the test case
	public static void createTestCase(String desc, String author, String category) {
		extenttest = extent.createTest(desc);
		extenttest.assignAuthor(author);
		extenttest.assignCategory(category);
	}

	// Method for creating the test steps
	public static void testStep(String status, String description) {
		switch (status.toLowerCase()) {
		case "pass":
			extenttest.pass(description);
			break;
		case "fail":
			extenttest.fail(description);
			break;
		case "information":
			extenttest.info(description);
			break;
		case "warning":
			extenttest.warning(description);
			break;
		default:
			System.err.println("Status not found");
		}
	}
}
