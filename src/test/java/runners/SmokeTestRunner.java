package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runs all smoke tests.
 *
 * @author Felipe.Rivas
 */
@CucumberOptions( features = "src/test/resources/features/",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        tags = "@SmokeTest"
)

public class SmokeTestRunner extends AbstractTestNGCucumberTests {
}
