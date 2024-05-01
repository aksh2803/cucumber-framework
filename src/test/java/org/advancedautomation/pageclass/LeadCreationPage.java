package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.reportgeneration.Report;
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

	@FindBy(xpath = "//slot[@name='primaryField']//child::lightning-formatted-name")
	private WebElement leadName;

//	@FindBy(xpath = "//span[contains(text(),'Show more actions')]//parent::button")
//	private WebElement downArrow;

	public void clickNewButton() {
		Report.createTestCase("TC003 - Lead Creation Page", "Akshaya", "Sanity");
		BaseClass.waitExplicitClick(newButton);
		newButton.click();
		Report.testStep("pass", "Clicked the new button.");
	}

	public void enterFirstName(String fname) {
		BaseClass.waitExplicitClick(firstName);
		firstName.sendKeys(fname);
		Report.testStep("pass", "Entered the first name");
	}

	public void enterLastName(String lname) {
		BaseClass.waitExplicitClick(lastName);
		lastName.sendKeys(lname);
		Report.testStep("pass", "Entered the last name");
	}

	public void enterCompany(String Comp) {
		if (Comp == null) {
			Report.testStep("fail", "Company is missing");
			Report.stopReport();
		} else {
			BaseClass.waitExplicitClick(company);
			company.sendKeys(Comp);
			Report.testStep("pass", "Entered the company name");
		}
	}

	public void enterTitle(String titleLead) {
		BaseClass.waitExplicitClick(title);
		title.sendKeys(titleLead);
		Report.testStep("pass", "Entered the title");
	}

	public void clickSaveBtn() {
		saveBtn.click();

	}

	public void leadReport() {
		BaseClass.waitImplicitClick();
		String chckTitle = leadName.getText().concat(" | Lead | Salesforce");
		if (driver.getTitle().equalsIgnoreCase(chckTitle))
			Report.testStep("pass", "Clicked the Save button");
		else {
			Report.testStep("fail", "Record creation failure");

		}
		Report.stopReport();
	}
	
	public String getLeadTitle() {
		return leadName.getText().concat(" | Lead | Salesforce");
	}
}
//		String title = driver.getTitle();
//		String checkTitle = fname + " " + lname + " | Lead | Salesforce";
//		System.out.println("Lead creation page title--- " + title);
//		System.out.println("Name --- " + lname);
//		System.out.println("CheckTitle --- " + checkTitle);
//
//		if (title.equalsIgnoreCase(checkTitle))
//			Report.testStep("pass", "Clicked the Save button");
//		else {
//			Report.testStep("fail", "Record creation failure");
//			Report.stopReport();
//		}
//		return fname + " " + lname;
//	}
//}
