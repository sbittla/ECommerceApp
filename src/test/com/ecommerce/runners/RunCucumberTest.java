package test.com.ecommerce.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "classpath:product_search.feature", glue = "classpath:stepdefinitions")
@CucumberOptions(
        features = "test/com/ecommerce/features",  // Path to feature files
        glue = {"test/com/ecommerce/stepdefinitions"},               // Path to step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class RunCucumberTest {
    // This will run the feature file with the defined step definitions
}

