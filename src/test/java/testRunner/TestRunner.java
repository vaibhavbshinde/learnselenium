package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"steps"},
		plugin = {"pretty","html:target/report/cucumber.html","json:target/json-report/cucumber.json"},
		dryRun = false,
		monochrome = true,
		tags = "@regression"
		)
//mvn clean test -Drun=TestRunner
public class TestRunner {

}

//		features = {"src/test/resources/features/EbayAdvancedSearch.feature"},