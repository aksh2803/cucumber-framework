package stepDefinitions;

import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.LeadCreationPage;

import io.cucumber.java.en.And;

public class LeadCreationStep extends BrowserClass {
	LeadCreationPage leadcreationpage;

//@Given("User is on the Lead page")
//public void user_is_on_the_lead_page() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
	@And("User should click the new button")
	public void user_should_click_the_new_button() {
		leadcreationpage = new LeadCreationPage(driver);
		leadcreationpage.clickNewButton();
	}

	@And("User enters the firstname as {string} and lastname as {string}")
	public void user_enters_the_firstname_as_and_lastname_as(String fname1, String lname1) {
		
		leadcreationpage.enterFirstName(fname1);
		leadcreationpage.enterLastName(lname1);
	}

	@And("User enters the company as {string} and title as {string}")
	public void user_enters_the_company_as_and_title_as(String comp, String title) {
		leadcreationpage.enterCompany(comp);
		leadcreationpage.enterTitle(title);
	}

	@And("User successfully created the lead record")
	public void user_successfully_created_the_lead_record() {
		leadcreationpage.clickSaveBtn();
	}
}
