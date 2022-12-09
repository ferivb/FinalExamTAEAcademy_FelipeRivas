package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( features = "src/test/resources/features/",
        glue = "stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        tags = "@MobileTest"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
