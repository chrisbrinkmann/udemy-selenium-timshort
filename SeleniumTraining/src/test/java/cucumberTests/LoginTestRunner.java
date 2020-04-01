package cucumberTests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
// Note that features path is relative to the project root
// And 'glue' is just the package containing the glue(steps) code
@CucumberOptions(features="src/test/resources/features", glue="steps")
public class LoginTestRunner {

}
