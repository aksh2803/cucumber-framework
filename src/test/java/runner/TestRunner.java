package runner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features/leadcreation.feature"
		//, "src/test/resources/Features/home.feature"
							  //"src/test/resources/Features/leadcreation.feature" 
		}, glue = "stepDefinitions", monochrome = true,
				plugin = {
				"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, tags = "@smoketest")
public class TestRunner extends AbstractTestNGCucumberTests	{

}
