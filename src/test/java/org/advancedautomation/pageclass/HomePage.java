package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverClass {

	public HomePage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath = "//div[contains(text(),'New')]")
//	private WebElement newButton;

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	private WebElement appLauncher;

	@FindBy(xpath = "//input[@class='slds-input']")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@class='al-menu-dropdown-list' and @aria-label='Items']")
	private WebElement clickLead;

	public void clickAppLauncher() {
		appLauncher.click();
	}

	public void getSearchBox() {
		searchBox.sendKeys("Leads");
	}

	public void clickLeadObj() {
		clickLead.click();
	}
	// Method for home page
//	public void homeMethod() throws InterruptedException {
//
//	}

}
