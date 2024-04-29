package stepDefinitions;

import java.time.Duration;

import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.LeadConversionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
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

	@And("User should click the dropdown")
	public void user_should_click_the_dropdown() {
		leadconversionpage = new LeadConversionPage(driver);
		leadconversionpage.clickDownArrow();
	}

	@And("User should click the convert button")
	public void user_should_click_the_convert_button() {
		leadconversionpage.clickConvertClick();
	}

	@And("User should click the convert lead button")
	public void user_should_click_the_convert_lead_button(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		leadconversionpage.clickConvertLead();
	}
}
