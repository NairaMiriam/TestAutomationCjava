package runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        format = { "json:target/cucumber.json","html:target/site/cucumber-pretty" },
        features = {"src/test/resources/feature"},
        glue = {"stepDefinition"},
        tags = {"@Id20"}
)

public class RunnerTest {

}
