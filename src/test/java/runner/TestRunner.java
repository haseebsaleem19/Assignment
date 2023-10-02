package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // Set the path to your feature files
        glue = "stepdefinitions" // Set the package where your step definitions are located
)
public class TestRunner {
}