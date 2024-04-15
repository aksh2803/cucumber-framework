package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		System.out.println("3333");
		userName.sendKeys(username);
	}

	public void getPassword(String pass) {
		System.out.println("3333");
		password.sendKeys(pass);
	}

	public void clickLogin() throws Throwable {
		loginBtn.click();
	}
}
