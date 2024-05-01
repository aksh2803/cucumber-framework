package stepDefinitions;

import org.advancedautomation.baseclass.BaseClass;
import org.advancedautomation.browserclass.BrowserClass;
import org.advancedautomation.pageclass.FieldHighlightPage;

import io.cucumber.java.en.Then;

public class FieldHighlightStep extends BrowserClass {
	
	FieldHighlightPage fieldhighlightpage;
	@Then("User should click the detail tab")
	public void user_should_click_the_detail_tab() {
		fieldhighlightpage = new FieldHighlightPage(BaseClass.getDriver());
		fieldhighlightpage.clickDetailTab();
	}

	@Then("User should highlight the lead owner")
	public void user_should_highlight_the_lead_owner() {
		
		fieldhighlightpage.highlightElement();
	}
}
