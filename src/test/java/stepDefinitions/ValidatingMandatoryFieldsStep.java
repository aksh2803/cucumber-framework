package stepDefinitions;

import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.ValidatingMandatoryFieldPage;

import io.cucumber.java.en.And;

public class ValidatingMandatoryFieldsStep extends BrowserClass {
	ValidatingMandatoryFieldPage validatingmandatoryfieldpage;

	@And("User clicks the new button")
	public void user_clicks_the_new_button() {
		validatingmandatoryfieldpage = new ValidatingMandatoryFieldPage(driver);
		validatingmandatoryfieldpage.nButton();
	}

	@And("User should click the save button")
	public void user_should_click_the_save_button() {
		validatingmandatoryfieldpage.sButton();
	}

	@And("Highlight the last name")
	public void highlight_the_last_name_() {
		validatingmandatoryfieldpage.printLabel();
	}
}
