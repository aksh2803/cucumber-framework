package org.advancedautomation.baseclass;

import java.io.ObjectInputFilter.Config;

import org.advancedautomation.pageclass.HomePage;
import org.advancedautomation.pageclass.LeadConversionPage;
import org.advancedautomation.pageclass.LeadCreationPage;
import org.advancedautomation.pageclass.LoginPage;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected static WebDriver driver;
	protected LoginPage loginpage;
	protected HomePage homepage;
	protected LeadCreationPage leadcreationpage;
	protected LeadConversionPage leadconversionpage;

	@BeforeSuite
	public void beforeSuite() throws Exception {
		driver=new ChromeDriver();
		driver.get("https://bhc5-dev-ed.my.salesforce.com/");
		driver.manage().window().maximize();
	}

//	@BeforeMethod
//	@Parameters({ "getBrowser" })
//	public void openBrowser(String getBrowser) {
//		{
//			try {
//				System.out.println("333");
//				//driver = BrowserClass.loadDriver(getBrowser.toUpperCase());
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--remote-allow-origins=*");
//				driver = new ChromeDriver(options);
//				System.out.println("444");
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//
//			driver.get(Config.getInfo("URL"));
//			driver.manage().window().maximize();
//		}
//	}
//
//	@AfterMethod
//	public void tearDown(ITestResult result) throws Exception {
//		String methodName = result.getMethod().getMethodName();
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			Screenshot.screenShot(methodName);
//
//			if (driver != null) {
//				{
//					driver.manage().deleteAllCookies();
//					driver.quit();
//				}
//			}
//
//		}
//
//	}

	@AfterSuite
	public void browserQuit() {
		driver.quit();
	}

}
