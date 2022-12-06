package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( features = "src/test/resources/features/SingUp.feature",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true
)

public class SingUp extends AbstractTestNGCucumberTests {
}
