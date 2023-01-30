package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles", glue = {"StepDefinitions"}, monochrome = true, plugin = {"pretty","json:target/cucumber-reports/reports.json",

        "junit:target/cucumber-reports/Cucumber.xml",

        "html:target/cucumber-reports/reports2.html"})

public class TestRunner {

}
