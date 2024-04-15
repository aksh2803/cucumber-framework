package stepDefinitions;

import java.time.Duration;

import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BrowserClass {
	
	LoginPage loginpage;

	@Given("User should navigate to the salesforce web application")
	public void user_should_navigate_to_the_salesforce_web_application() throws Exception {
		System.out.println("1111");
		String Title = driver.getTitle();
		System.out.println("=========== "+Title);
	}

	@When("User should enter the username as {string} and password as {string}")
	public void user_should_enter_the_username_and_password(String username, String password) {
		loginpage = new LoginPage(driver);
		loginpage.getUserName(username);
		loginpage.getPassword(password);

	}

	@Then("User should click the login button")
	public void user_should_click_the_login_button() throws Throwable {
		loginpage.clickLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
