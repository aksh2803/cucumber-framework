package org.advancedautomation.baseclass;

import java.time.Duration;

import org.advancedautomation.pageclass.HomePage;
import org.advancedautomation.pageclass.LeadConversionPage;
import org.advancedautomation.pageclass.LeadCreationPage;
import org.advancedautomation.pageclass.LoginPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	private static BaseClass baseClass;
	private static WebDriver driver;
	protected LoginPage loginpage;
	protected HomePage homepage;
	protected LeadCreationPage leadcreationpage;
	protected LeadConversionPage leadconversionpage;

	public BaseClass() {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akshaya.b\\git\\cucumber-framework\\myDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void openUrl() {
		driver.get("https://bhc5-dev-ed.my.salesforce.com/");
	}

//	
	public static WebDriver getDriver() {
		return driver;
	}

//	
	public static void setUpDriver() {
		if (baseClass == null) {
			baseClass = new BaseClass();
		}
	}

	// Method for implicit wait
	public static void waitImplicitClick() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// Method for explicit wait
	public static void waitExplicitClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method for fluent Wait
	public static void waitFluentClick(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		baseClass = null;
	}

}
