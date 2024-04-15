package org.advancedautomation.browserclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserClass {

	protected static WebDriver driver;

	public static WebDriver openBrowser(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browser.equals("internetexplorer")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Invalid Browser");
		}

		return driver;
	}
}
