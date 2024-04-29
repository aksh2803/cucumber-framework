package stepDefinitions;

import java.time.Duration;

import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


public class HomeStep extends BrowserClass {

	HomePage homepage;
	
	@Description("Verify the lead tab is clicked successfully")
	@Epic("EP002")
	@Feature("Feature1: HomePage")
	@Story("Story: lead tab ")
	@Step("Verify the lead tab clicked")
	@Severity(SeverityLevel.MINOR)

	@Given("User is on the salesforce home page")
	public void user_is_on_the_salesforce_home_page() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Then("User should click the app launcher")
	public void user_should_click_the_app_launcher() {
		homepage = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homepage.clickAppLauncher();

	}

	@Then("User should click the search box")
	public void user_should_click_the_search_box() {
		homepage.getSearchBox();
	}

	@Then("User should click the leads")
	public void user_should_click_the_leads() {
		homepage.clickLeadObj();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
