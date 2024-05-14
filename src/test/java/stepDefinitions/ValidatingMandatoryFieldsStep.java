package stepDefinitions;

import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.ValidatingMandatoryFieldPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ValidatingMandatoryFieldsStep extends BrowserClass {
	ValidatingMandatoryFieldPage validatingmandatoryfieldpage;

	@Given("User navigates to the Lead page")
	public void user_navigates_to_the_lead_page() throws InterruptedException {
		validatingmandatoryfieldpage = new ValidatingMandatoryFieldPage(BaseClass.getDriver());
		validatingmandatoryfieldpage.toLeads();
	}

	@And("User clicks the new button")
	public void user_clicks_the_new_button() throws InterruptedException {
		validatingmandatoryfieldpage.nButton();
	}

	@And("User should click the save button")
	public void user_should_click_the_save_button() throws InterruptedException {
		validatingmandatoryfieldpage.sButton();
	}

	@And("Highlight the last name")
	public void highlight_the_last_name_() {
		validatingmandatoryfieldpage.printLabel();
	}
	
	@And("Click the close button")
	public void click_the_close_button() throws InterruptedException {
		validatingmandatoryfieldpage.closeBtn();
	}
}
