package org.advancedautomation.pageclass;

import java.util.List;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ValidatingMandatoryFieldPage extends DriverClass {
	JavascriptExecutor js;

	public ValidatingMandatoryFieldPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(text(),'New')]")
	private WebElement newButton;

	@FindBy(xpath = "//button[contains(text(),'Save') and @name=\"SaveEdit\"]")
	private WebElement saveBtn;

	@FindBy(xpath = "//abbr[@title='required']//parent::label")
	private List<WebElement> label1;

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

	public void nButton() {
		newButton.click();
		BaseClass.waitImplicitClick();
//		String currUrl = driver.getCurrentUrl();
//		Assert.assertEquals(currUrl, "https://login.salesforce.com/?locale=in");
	}

	public void sButton() {
		BaseClass.waitImplicitClick();
		saveBtn.click();
	}

}
