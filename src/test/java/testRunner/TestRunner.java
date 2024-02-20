package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"html:reports/cucumber-reports.html"},
        features = {"classpath:features"},
        glue = {"classpath:stepDefinitions"},
        tags = "@ClickResetPassword"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
