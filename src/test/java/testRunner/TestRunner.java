package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = {"classpath:features"},
        glue = {"classpath:stepDefinitions"},
        tags = "@ValidLogin"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
