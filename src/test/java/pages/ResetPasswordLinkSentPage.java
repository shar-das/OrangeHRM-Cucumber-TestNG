package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordLinkSentPage {

    String actualUrl;
    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";

    public ResetPasswordLinkSentPage(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(xpath = "//h6[text()='Reset Password link sent successfully']")
    public WebElement pageHeading;

    @FindBy(xpath = "//p[text()='A reset password link has been sent to you via email.']")
    public WebElement resetMessageLine1;

    @FindBy(xpath = "//p[text()='You can follow that link and select a new password.']")
    public WebElement getResetMessageLine2;

    @FindBy(xpath = "//p[text()='If the email does not arrive, please contact your OrangeHRM Administrator.']")
    public WebElement noteMessage;

    public boolean verify_messages() {
        return (resetMessageLine1.isDisplayed() && getResetMessageLine2.isDisplayed() && noteMessage.isDisplayed());
    }

    public boolean check_url(WebDriver driver) {
        actualUrl = driver.getCurrentUrl();
        return actualUrl.equalsIgnoreCase(expectedUrl);
    }
}
