package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber-report/cucumber.html"},
		features = {"src/test/resources/features"},
		glue = {"stepdefinition","testrunner"},
		monochrome = true
		)
public class TestRunner {
	

}


