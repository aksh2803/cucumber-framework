package runner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features/leadconversion.feature"
		//, "src/test/resources/Features/home.feature"
							  //"src/test/resources/Features/leadcreation.feature" 
		}, glue = "stepDefinitions", monochrome = true, 
				plugin = {
				"pretty", "html:target/HTMLReports/report.html", "json:target/JSONReports/report.json",
				"junit:target/JunitReports/report.xml" }, tags = "@smoketest")
public class TestRunner extends AbstractTestNGCucumberTests	{

}
