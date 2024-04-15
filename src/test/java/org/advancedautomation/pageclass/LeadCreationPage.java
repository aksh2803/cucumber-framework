package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadCreationPage extends DriverClass {

	public LeadCreationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(text(),'New')]")
	private WebElement newButton;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='Company']")
	private WebElement company;

	@FindBy(xpath = "//input[@name='Title']")
	private WebElement title;

	@FindBy(xpath = "//button[contains(text(),'Save') and @name=\"SaveEdit\"]")
	private WebElement saveBtn;

//	@FindBy(xpath = "//span[contains(text(),'Show more actions')]//parent::button")
//	private WebElement downArrow;

	public void clickNewButton() {
		newButton.click();
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterCompany(String Comp) {
		company.sendKeys(Comp);
	}

	public void enterTitle(String titleLead) {
		title.sendKeys(titleLead);
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	// Method for lead creation page
	/*
	 * public String leadCreationMethod() throws Exception {
	 * 
	 * clickButton(newButton);
	 * 
	 * waitImplicitClick(); clickButton(leadSource); clickButton(optionWeb);
	 * clickButton(industry); clickButton(optionIndustry);
	 * 
	 * clickButton(region); clickButton(optionRegion);
	 * 
	 * clickButton(rating); clickButton(optionRating);
	 * 
	 * clickButton(saveBtn); waitExplicitClick(downArrow);
	 * 
	 * }
	 */
}
