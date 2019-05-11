import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginPage extends PageBasis {
    private static final String URL = "https://www.tut.by/";
    private static final String LOGIN_TITLE = "Белорусский портал TUT.BY. Новости Беларуси и мира";
    private static final String LOGIN_USERNAME = "seleniumtests@tut.by";
    private static final String LOGIN_PASSWORD = "123456789zxcvbn";
    private static final By LABEL_LOGGED_USER_NAME = By.xpath("//span[@class = 'uname']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(URL);
    }

    public String loginTitle() {
        return LOGIN_TITLE;
    }

    @FindBy(xpath = "//a[@class = 'enter']")
    private WebElement loginMenuItem;

    public WebElement loginMenuItem() {
        return loginMenuItem;
    }

    @FindBy(xpath = "//input[@name = 'login']")
    private WebElement inputLoginUsername;

    public void enterLoginUsername() {
        inputLoginUsername.sendKeys(LOGIN_USERNAME);
    }

    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement inputLoginPassword;

    public void enterLoginPassword() {
        inputLoginPassword.sendKeys(LOGIN_PASSWORD);
    }

    @FindBy(xpath = "//input[@class = 'button auth__enter']")
    private WebElement buttonLoginSubmit;

    public WebElement buttonLoginSubmit() {
        return buttonLoginSubmit;
    }

    public void login() {
        open();
        wait.until(titleIs(loginTitle()));
        loginMenuItem().click();
        enterLoginUsername();
        enterLoginPassword();
        buttonLoginSubmit().click();
        new Actions(driver).click().perform();
    }

    public By labelLoggedUsername() {
        return LABEL_LOGGED_USER_NAME;
    }

    @FindBy(xpath = "//span[@class = 'uname']")
    private WebElement labelLoggedUserName;

    public String getTextOfLabelLoggedUsername() {
        String getTextOfLabelLoggedUsername = labelLoggedUserName.getText();
        return getTextOfLabelLoggedUsername;
    }

    @FindBy(xpath = "//a[@class = 'enter logedin']")
    private WebElement linkLogoutMenuItem;

    public WebElement linkLogoutMenuItem() {
        return linkLogoutMenuItem;
    }

    @FindBy(xpath = "//a[@class = 'button wide auth__reg']")
    private WebElement buttonLogout;

    public WebElement buttonLogout() {
        return buttonLogout;
    }

    @FindBy(xpath = "//a[@class = 'enter']")
    private WebElement labelLoggedOut;

    public String getTextOfLabelLoggedOut() {
        String getTextOfLabelLoggedOut = labelLoggedOut.getText();
        return getTextOfLabelLoggedOut;
    }
}