package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FieldHighlightPage extends DriverClass {
	JavascriptExecutor js;

	public FieldHighlightPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@title='Details']//child::a")
	private WebElement detailTab;

	@FindBy(xpath = "//span[contains(text(),'Lead Owner')]")
	private WebElement leadOwner;

	public void clickDetailTab() {
		BaseClass.waitExplicitClick(detailTab);
		detailTab.click();
	}

	public void highlightElement() {
		BaseClass.waitExplicitClick(leadOwner);
		String script = "arguments[0].style.backgroundColor = 'green'; "
				+ "arguments[0].style.border = '2px solid red';";
		((JavascriptExecutor) driver).executeScript(script, leadOwner);
	}
}
