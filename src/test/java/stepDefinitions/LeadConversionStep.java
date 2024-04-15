package stepDefinitions;

import java.time.Duration;

import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.LeadConversionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;

public class LeadConversionStep extends BrowserClass {
	LeadConversionPage leadconversionpage;

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
