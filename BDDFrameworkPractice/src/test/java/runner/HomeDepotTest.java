package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        format = {"pretty", "html:target/site/cucumber-pretty",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"},
        tags = {"@SeeResults, @AddToCart"}
)
public class HomeDepotTest {
}
