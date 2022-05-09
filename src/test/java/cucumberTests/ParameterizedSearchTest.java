package cucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/parametirezed-search.feature",
        plugin = {"pretty","html:out"})
public class ParameterizedSearchTest {
}
