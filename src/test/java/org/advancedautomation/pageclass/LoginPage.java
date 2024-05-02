package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.reportgeneration.Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends DriverClass {
	// constructor to initialize web elements

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"Login\"]")
	private WebElement loginBtn;

	public void getUserName(String username) {
		Report.startReport();
		Report.createTestCase("TC001 - Login Page", "Akshaya", "Sanity");
		userName.sendKeys(username);
		Report.testStep("pass", "Username Entered");
	}

	public void getPassword(String pass) {
		password.sendKeys(pass);
		Report.testStep("pass", "Password Entered");
	}

	public void clickLogin() throws Throwable {
		loginBtn.click();
		//BaseClass.waitExplicitClick(loginBtn);
		String currUrl = driver.getCurrentUrl();
		//Assert.assertEquals(currUrl, "https://bhc5-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home");
		System.out.println("Login Page Current URL - " + currUrl);
		if (currUrl.equals("https://bhc5-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home")) {
			Report.testStep("pass", "Logged In Successfully");
		} else {
			Report.testStep("fail", "Login failed");

		}
		Report.stopReport();
	}
}
