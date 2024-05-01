package stepDefinitions;

import org.advancedautomation.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;

public class Hooks {
	protected static WebDriver driver;

	@Before
	public void setup() {
		BaseClass.setUpDriver();
	}

}
