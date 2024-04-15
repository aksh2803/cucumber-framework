package org.advancedautomation.pageclass;

import org.advancedautomation.abstractclass.DriverClass;
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
		detailTab.click();
	}

	public void highlightElement() {
		String script = "arguments[0].style.backgroundColor = 'green'; "
				+ "arguments[0].style.border = '2px solid red';";
		((JavascriptExecutor) driver).executeScript(script, leadOwner);
//		js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('style', 'border: 5px solid green;');", leadOwner);
	}
}
