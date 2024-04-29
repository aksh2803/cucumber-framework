package stepDefinitions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.db.Database;
import org.advancedautomation.pageclass.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginStep extends BrowserClass {

	LoginPage loginpage;

	@Description("Verify the salesforce login page")
	@Epic("EP001")
	@Feature("Feature1: Login")
	@Story("Story: Verify login")
	@Step("Verify the salesforce log in")
	@Severity(SeverityLevel.MINOR)

	@Given("User should navigate to the salesforce web application")
	public void user_should_navigate_to_the_salesforce_web_application() throws Exception {
		String Title = driver.getTitle();
		System.out.println("The title is: " + Title);
	}

	@When("User should enter the username and password")
	public void user_should_enter_the_username_and_password() throws SQLException {
		loginpage = new LoginPage(driver);
		ResultSet resultSet = Database.getLoginCredentials();
		if (resultSet.next()) {
			String dbUsername = resultSet.getString("username");
			String dbPassword = resultSet.getString("password");

			// Credentials match, perform login action
			loginpage.getUserName(dbUsername);
			loginpage.getPassword(dbPassword);
		}
	}
//		loginpage.getUserName(username);
//		 loginpage.getPassword(password);

	@Then("User should click the login button")
	public void user_should_click_the_login_button() throws Throwable {
		loginpage.clickLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
