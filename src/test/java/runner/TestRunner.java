package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber/report.html",
                "json:target/cucumber/reports.json",
                "junit:target/cucumber/reports.xml",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        tags = "@completeCheckout"
)
public class TestRunner {
}
