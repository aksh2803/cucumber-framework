package org.advancedautomation.abstractclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class DriverClass {
	protected WebDriver driver;
	protected JavascriptExecutor js;

	public DriverClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
