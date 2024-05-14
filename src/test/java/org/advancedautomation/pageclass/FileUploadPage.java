package org.advancedautomation.pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.advancedautomation.abstractclass.DriverClass;
import org.advancedautomation.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage extends DriverClass {
	// constructor to initialize web elements
	Actions actions = new Actions(driver);

	public FileUploadPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='Files']")
	private WebElement clickFiles;

	@FindBy(xpath = "//a[@title='Upload Files']//child::div[contains(text(),'Upload Files')]")
	private WebElement clickuploadFiles;

	@FindBy(xpath = "//span[contains(text(),'Done')]")
	private WebElement done;

	public void clickFileBtn() throws InterruptedException {
		try {
			System.out.println("Before wait method === " + driver);
			Thread.sleep(10000);

			actions.moveToElement(clickFiles).click().perform();
			System.out.println("After wait method === ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickUploadBtn() throws InterruptedException, AWTException {
		String filePath = "C:\\Users\\Akshaya.b\\Downloads\\Insurance.pdf";
		Thread.sleep(10000);
		clickuploadFiles.click();
		
		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("666");
	}

	public void clickDone() throws InterruptedException {
		
		done.click();
	}

}
