package stepDefinitions;

import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.LeadConversionPage;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LeadConversionStep extends BrowserClass {
	LeadConversionPage leadconversionpage;

	@Description("Verify the lead is converted successfully")
	@Epic("EP003")
	@Feature("Feature1: lead conversion")
	@Story("Story: Verify the lead conversion")
	@Step("Verify lead conversion is success")
	@Severity(SeverityLevel.MINOR)

	@Given("User is on the lead conversion page")
	public void user_is_on_the_lead_conversion_page() {
		leadconversionpage = new LeadConversionPage(BaseClass.getDriver());
	}

	@And("User should click the dropdown")
	public void user_should_click_the_dropdown() {

		leadconversionpage.clickDownArrow();
	}

	@And("User should click the convert button")
	public void user_should_click_the_convert_button() {
		leadconversionpage.clickConvertClick();
	}

	@And("User should click the convert lead button")
	public void user_should_click_the_convert_lead_button() throws Exception {
		leadconversionpage.clickConvertLead();
		leadconversionpage.leadConversionReport();
	}
}
