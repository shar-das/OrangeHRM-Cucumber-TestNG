package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    String actualUrl;
    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";

    public ForgotPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//button[contains(@class,'reset')]")
    public WebElement resetButton;

    @FindBy(xpath = "//button[contains(@class,'cancel')]")
    public WebElement cancelButton;

    public void enter_username_and_click_reset_password(String username) {
        usernameTextBox.sendKeys(username);
        resetButton.click();
    }

    public boolean check_url(WebDriver driver) {
        actualUrl = driver.getCurrentUrl();
        return actualUrl.equalsIgnoreCase(expectedUrl);
    }
}
