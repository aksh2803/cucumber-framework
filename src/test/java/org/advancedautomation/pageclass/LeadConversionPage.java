package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadConversionPage extends DriverClass {

	public LeadConversionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Show more actions')]//parent::button")
	private WebElement downArrow;

	@FindBy(xpath = "//span[contains(text(),'Convert')]//parent::a[@role= 'menuitem']")
	private WebElement convertClick;

	@FindBy(xpath = "//span[@data-target-selection-internal = 'true']//child::button[contains(text(),'Convert')]")
	private WebElement convertLead;

	@FindBy(xpath = "//h2[contains(text(),'Your lead has been converted')]")
	private WebElement verifyTitle;

	public void clickDownArrow() {
		downArrow.click();
	}

	public void clickConvertClick() {
		convertClick.click();
	}

	public void clickConvertLead() {
		convertLead.click();
	}

	public String convertVerifyTitle() {
		return verifyTitle.getText();
	}

	// Method for lead conversion page
	public void leadConversionMethod(String name) throws InterruptedException {

	}
}
