package stepDefinitions;

import java.io.ByteArrayInputStream;

import org.advancedautomation.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class Hooks {
	protected static WebDriver driver;

	@Before
	public void setup() {
		BaseClass.setUpDriver();
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
		 byte[] screenshot = ((TakesScreenshot)BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
		 Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
		}
		//BaseClass.tearDown();
	}
}
