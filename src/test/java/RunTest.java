import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = {"src/main/resources/features/"},
        glue = {"com.elsevier.qa.stepDefs"},
        tags = {"@Test"},
        plugin = {"pretty", "json:target/cucumber.json","html:target/cucumber-html","html:target/cucumber-reports"}
)

public class RunTest {
}
