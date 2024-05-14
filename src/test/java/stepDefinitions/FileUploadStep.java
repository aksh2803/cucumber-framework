package stepDefinitions;

import java.awt.AWTException;

import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.FileUploadPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class FileUploadStep extends BrowserClass {
	FileUploadPage fileupload;

	@Given("User clicks the file upload tab")
	public void user_clicks_the_file_upload_tab() throws InterruptedException {
		System.out.println("111");
		fileupload = new FileUploadPage(BaseClass.getDriver());
		BaseClass.openUrl();
		System.out.println("222");
		fileupload.clickFileBtn();
		System.out.println("333");
	}

	@And("User clicks the upload files button")
	public void user_clicks_the_upload_files_button() throws InterruptedException, AWTException {
		System.out.println("444");
		fileupload.clickUploadBtn();
	}

//		@And("User chooses the file")
//		public void user_chooses_the_file() {
	//
//		}

	@And("User clicks the done button")
	public void user_clicks_the_done_button() throws InterruptedException {
		Thread.sleep(20000);
		fileupload.clickDone();
	}
}
