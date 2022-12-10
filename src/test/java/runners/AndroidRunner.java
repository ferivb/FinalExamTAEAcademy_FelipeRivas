package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runs all mobile tests.
 *
 * @author Felipe.Rivas
 */
@CucumberOptions( features = "src/test/resources/features/",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        tags = "@MobileTest"
)

public class AndroidRunner extends AbstractTestNGCucumberTests {
}
