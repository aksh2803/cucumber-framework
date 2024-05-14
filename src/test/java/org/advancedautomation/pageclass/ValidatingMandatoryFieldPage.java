package org.advancedautomation.pageclass;

import java.util.List;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValidatingMandatoryFieldPage extends DriverClass {
	JavascriptExecutor js;

	public ValidatingMandatoryFieldPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(text(),'Go to Leads')]")
	private WebElement goToLeads;

	@FindBy(xpath = "//div[contains(text(),'New')]")
	private WebElement newButton;

	@FindBy(xpath = "//button[contains(text(),'Save') and @name=\"SaveEdit\"]")
	private WebElement saveBtn;

	@FindBy(xpath = "//abbr[@title='required']//parent::label")
	private List<WebElement> label1;

	@FindBy(xpath = "//button[@type='button']//lightning-primitive-icon//*[local-name()='svg' and @data-key='close']")
	private WebElement close;

	public void toLeads() throws InterruptedException {
		goToLeads.click();
		Thread.sleep(5000);
		// BaseClass.waitImplicitClick();
	}

	public void nButton() throws InterruptedException {
		newButton.click();
		Thread.sleep(5000);
		// BaseClass.waitImplicitClick();
//		String currUrl = driver.getCurrentUrl();
//		Assert.assertEquals(currUrl, "https://login.salesforce.com/?locale=in");
	}

	public void sButton() throws InterruptedException {
		Thread.sleep(5000);
		// BaseClass.waitImplicitClick();
		saveBtn.click();
		Thread.sleep(5000);
	}

	public void closeBtn() throws InterruptedException {
		close.click();
		Thread.sleep(5000);
	}

	public void printLabel() {
		for (WebElement label : label1) {
			String fieldLabel = label.getText();
			System.out.println("--------" + fieldLabel);
			highlightElement(label);
		}
	}

	// Method to highlight a web element
	public void highlightElement(WebElement label) {
		String script = "arguments[0].style.backgroundColor = 'yellow'; "
				+ "arguments[0].style.border = '2px solid red';";
		((JavascriptExecutor) driver).executeScript(script, label);
	}

}
