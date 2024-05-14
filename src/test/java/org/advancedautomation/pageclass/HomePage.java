package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.reportgeneration.Report;
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

	public void clickAppLauncher() throws InterruptedException {
		Report.createTestCase("TC002 - Home Page", "Akshaya", "Sanity");
		//BaseClass.waitExplicitClick(appLauncher);
		appLauncher.click();
		Report.testStep("pass", "AppLauncher clicked");
	}

	public void getSearchBox() {
		BaseClass.waitExplicitClick(searchBox);
		searchBox.sendKeys("Leads");
		Report.testStep("pass", "Clicked the searchbox and entered the value lead");
	}

	public void clickLeadObj() throws InterruptedException {
		BaseClass.waitExplicitClick(clickLead);
		clickLead.click();
		Thread.sleep(10000);
		Report.testStep("pass", "Clicked the lead object");
		String currUrl = driver.getCurrentUrl();
		System.out.println("Home Page Current URL - " + currUrl);
		if (currUrl.equals("https://bhc5-dev-ed.lightning.force.com/lightning/o/Lead/list?filterName=Recent")) {
			Report.testStep("pass", "Clicked the Leads");
		} else {
			Report.testStep("fail", "Lead page is not found.");
			
		}
		Report.stopReport();
	}
	

}
