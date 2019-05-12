import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginPage extends PageBasis {
    private static final String URL = "https://www.tut.by/";
    private static final String LOGIN_TITLE = "Белорусский портал TUT.BY. Новости Беларуси и мира";
    private static final By LABEL_LOGGED_USER_NAME = By.xpath("//span[@class = 'uname']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    @FindBy(xpath = "//a[@class = 'enter']")
    private WebElement loginMenuItem;

    private WebElement loginMenuItem() {
        return loginMenuItem;
    }

    @FindBy(xpath = "//input[@name = 'login']")
    private WebElement inputLoginUsername;

    private void enterLoginUsername(String loginUsername) {
        inputLoginUsername.sendKeys(loginUsername);
    }

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement inputLoginPassword;

    private void enterLoginPassword(String password) {
        inputLoginPassword.sendKeys(password);
    }

    @FindBy(xpath = "//input[@class = 'button auth__enter']")
    private WebElement buttonLoginSubmit;

    private WebElement buttonLoginSubmit() {
        return buttonLoginSubmit;
    }

    public LoggedInPage login(String loginUsername, String password) {
        open();
        wait.until(titleIs(LOGIN_TITLE));
        loginMenuItem().click();
        enterLoginUsername(loginUsername);
        enterLoginPassword(password);
        buttonLoginSubmit().click();
        new Actions(driver).click().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(labelLoggedUsername()));
        return new LoggedInPage(driver, wait);
    }

    private By labelLoggedUsername() {
        return LABEL_LOGGED_USER_NAME;
    }

    @FindBy(xpath = "//span[@class = 'uname']")
    private WebElement labelLoggedUserName;

    public String getTextOfLabelLoggedUsername() {
        String getTextOfLabelLoggedUsername = labelLoggedUserName.getText();
        return getTextOfLabelLoggedUsername;
    }
}