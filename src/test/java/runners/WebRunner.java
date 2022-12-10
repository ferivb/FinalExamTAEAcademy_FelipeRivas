package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runs all web tests.
 *
 * @author Felipe.Rivas
 */
@CucumberOptions( features = "src/test/resources/features/",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        tags = "@WebTest"
)

public class WebRunner extends AbstractTestNGCucumberTests {
}
