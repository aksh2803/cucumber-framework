package stepDefinitions;

import org.advancedautomation.browserclass.BrowserClass;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	protected static WebDriver driver;
	
	@Before
	public void setup() {
		driver = BrowserClass.openBrowser("chrome"); 
		driver.get("https://bhc5-dev-ed.my.salesforce.com/");
		driver.manage().window().maximize();
	}
	
//	@After
//	public void teardown() {
//		driver.quit();
//	}
}
