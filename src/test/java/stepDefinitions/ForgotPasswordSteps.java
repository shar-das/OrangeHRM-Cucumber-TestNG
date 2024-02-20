package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.ResetPasswordLinkSentPage;
import utils.commonMethods;

public class ForgotPasswordSteps extends commonMethods {

    WebDriver driver;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;
    ResetPasswordLinkSentPage resetPasswordLinkSentPage;

    public ForgotPasswordSteps() {
        super();
        driver = getDriver();
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        resetPasswordLinkSentPage = new ResetPasswordLinkSentPage(driver);
    }

    @Given("User is on OrangeHRM login page and clicks on forgot your password")
    public void navigate_to_login_page_and_click_forgot_your_password() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        dynamicWait(loginPage.forgotPasswordLink);
        loginPage.forgotPasswordLink.click();
    }

    @When("User is taken to reset password page")
    public void verify_user_is_taken_To_reset_password_page() {
        dynamicWait(forgotPasswordPage.usernameTextBox);
        Assert.assertTrue(forgotPasswordPage.check_url(driver));
    }

    @Then("User is able to enter username as {string} and click on reset password")
    public void verify_user_is_able_to_enter_Username_and_click_on_reset_password(String username) {
        forgotPasswordPage.enter_username_and_click_reset_password(username);
    }

    @And("User is taken to reset password link sent page")
    public void verify_user_is_taken_to_reset_password_link_sent_page() {
        dynamicWait(resetPasswordLinkSentPage.pageHeading);
        Assert.assertTrue(resetPasswordLinkSentPage.check_url(driver));
        Assert.assertTrue(resetPasswordLinkSentPage.verify_messages());
    }

    @When("User is taken to reset password page and clicks cancel")
    public void user_is_taken_to_reset_password_page_and_clicks_cancel() {
        dynamicWait(forgotPasswordPage.usernameTextBox);
        Assert.assertTrue(forgotPasswordPage.check_url(driver));
        forgotPasswordPage.cancelButton.click();
    }

    @Then("User is taken back to login page")
    public void verify_user_is_taken_back_to_login_page() {
        dynamicWait(loginPage.usernameTextbox);
        Assert.assertTrue(loginPage.check_url(driver));
    }

    @After
    public void close_browser() { driver.quit(); }
}
