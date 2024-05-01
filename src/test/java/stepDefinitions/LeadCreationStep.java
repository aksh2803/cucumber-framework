package stepDefinitions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.constantclass.Constant;
import org.advancedautomation.db.Database;
import org.advancedautomation.pageclass.LeadCreationPage;
import org.advancedautomation.utils.DataUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LeadCreationStep extends BrowserClass {
	LeadCreationPage leadcreationpage;
	String firstName;
	String lastname;
	String company;
	String title;

	@Description("Verify the lead is created successfully")
	@Epic("EP003")
	@Feature("Feature1: lead creation")
	@Story("Story: Verify lead creation ")
	@Step("Verify lead creation is success")
	@Severity(SeverityLevel.MINOR)

	@Given("User is on the Lead page")
	public void user_is_on_the_lead_page() {
		leadcreationpage = new LeadCreationPage(BaseClass.getDriver());
	}
//	@ParameterType(".*")
//	public String lead(String value) {
//		return new String(value);
//	}

	@And("User should click the new button")
	public void user_should_click_the_new_button() {

		leadcreationpage.clickNewButton();
	}

	@Then("User enters the sheetname {string} and rownumber {int}")
	public void user_enters_the_sheetname_and_rownumber(String Sheetname, Integer RowNumber)
			throws InvalidFormatException, IOException {
		DataUtils datautils = new DataUtils();
		List<Map<String, String>> checkData = datautils.getValues(Constant.DATAFILEPATH, Sheetname);
		firstName = checkData.get(RowNumber).get("firstname");
		leadcreationpage.enterFirstName(firstName);
		lastname = checkData.get(RowNumber).get("lastname");
		leadcreationpage.enterLastName(lastname);
		company = checkData.get(RowNumber).get("company");
		leadcreationpage.enterCompany(company);
		title = checkData.get(RowNumber).get("title");
		leadcreationpage.enterTitle(title);
	}

	@And("Insert the values into the database")
	public void insert_the_values_into_the_database() {
		try {
			Database.insertData(firstName, lastname, company, title);
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle database insertion error
		}
	}

	@And("User successfully created the lead record")
	public void user_successfully_created_the_lead_record() {
		leadcreationpage.clickSaveBtn();
		leadcreationpage.leadReport();
	}
}
