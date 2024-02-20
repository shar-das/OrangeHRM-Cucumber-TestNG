package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.commonMethods;

public class LoginSteps extends commonMethods {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    String actualUrl, expectedUrl;

    public LoginSteps() {
        super();
        driver = getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Given("User is on OrangeHRM login page")
    public void navigate_to_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User enters username as {string} and password as {string} and clicks on login")
    public void enter_username_and_password(String username, String password) {
        dynamicWait(loginPage.usernameTextbox);
        loginPage.login(username, password);
    }

    @Then("User is logged in and navigated to landing page")
    public void verify_user_logged_in() {
        dynamicWait(dashboardPage.dashboardHeading);
        Assert.assertTrue(dashboardPage.check_url(driver));
    }

    @Then("User should be able to see {string}")
    public void verify_error_message(String expectedErrorMessage) {
        dynamicWait(loginPage.errorMessage);
        Assert.assertTrue(loginPage.check_error_message(driver));
    }

    @After
    public void close_browser() {
        driver.quit();
    }

}
