package testRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/",
		glue = "stepDefinitions",
		monochrome = true,	// remove unnecessary characters in console window	
		dryRun = false,	// without running the tests, it first checks whether your feature file have corresponding steps defined or not if its true
		tags = "@sanity or @regression", // running test cases with either of the tags
		plugin = {"pretty",
				"html:target/cucumber-report/cucumber.html",	// creating html reports in target folder
				"json:target/cucumber.json",
				//"json:target/cucumber-report/cucumber.json" // try either of the above json reports
		}
		
		)
public class TestRunner {

}
