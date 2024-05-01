package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.reportgeneration.Report;
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
		Report.createTestCase("TC004 - Lead Conversion Page", "Akshaya", "Sanity");
		BaseClass.waitExplicitClick(downArrow);
		downArrow.click();
		Report.testStep("pass", "Clicked the Dropdown button");
	}

	public void clickConvertClick() {
		BaseClass.waitExplicitClick(convertClick);
		convertClick.click();
		Report.testStep("pass", "Clicked the Convert button from the dropdown");
	}

	public void clickConvertLead() throws Exception {
		//BaseClass.waitFluentClick(convertLead);
		Thread.sleep(10000);
		convertLead.click();
	}

//	public String convertVerifyTitle() {
//		return verifyTitle.getText();
//	}

	// Method for lead conversion page
	public void leadConversionReport() throws InterruptedException {

//		String title1 = driver.getTitle();
//		System.out.println("Lead Conversion Page title--- " + title1);
//		String checkTitle = name + " | Lead | Salesforce";
//		System.out.println("checkTitle --- " + checkTitle);
	//	System.out.println(" ---- " + verifyTitle.get);
		LeadCreationPage leadCreation = new LeadCreationPage(driver);
		if (leadCreation.getLeadTitle().equalsIgnoreCase(driver.getTitle()))
			Report.testStep("pass", "Lead got converted successfully.");
		else {
			Report.testStep("fail", "Lead conversion failure");

		}
		Report.stopReport();
	}
}
