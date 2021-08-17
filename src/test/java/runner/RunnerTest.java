package runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/feature"},
        glue = {"stepDefinition"},
        tags = {"@HappyPath","@Tag01"}
)

public class RunnerTest {

}
