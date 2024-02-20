package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    String actualUrl;
    String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    public WebElement dashboardHeading;

    public boolean check_url(WebDriver driver) {
        actualUrl = driver.getCurrentUrl();
        return actualUrl.equalsIgnoreCase(expectedUrl);
    }

}
