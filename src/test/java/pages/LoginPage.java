package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    String actualErrorMessage, actualUrl;
    String expectedErrorMessage = "Invalid credentials";
    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement usernameTextbox;

    @FindBy(name = "password")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@role='alert']//child::p")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@class='orangehrm-login-forgot']//child::p")
    public WebElement forgotPasswordLink;

    public void login(String username, String password) {
        usernameTextbox.sendKeys(username);
        passwordTextbox.sendKeys(password);
        loginButton.click();
    }

    public boolean check_error_message(WebDriver driver) {
        actualErrorMessage = errorMessage.getText();
        return actualErrorMessage.equalsIgnoreCase(expectedErrorMessage);
    }

    public boolean check_url(WebDriver driver) {
        actualUrl = driver.getCurrentUrl();
        return actualUrl.equalsIgnoreCase(expectedUrl);
    }

}
