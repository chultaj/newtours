import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"pretty", "html:reports/cucumber-reports"}, features="src/test/resources/features")
public class CucumberTestsRunner extends AbstractTestNGCucumberTests {
}
