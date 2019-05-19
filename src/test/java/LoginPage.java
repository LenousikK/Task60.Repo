import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginPage extends PageBasis {
    private static final String URL = "https://www.tut.by/";
    private static final String LOGIN_TITLE = "Белорусский портал TUT.BY. Новости Беларуси и мира";
    private static final By LOGIN_MENU_ITEM = By.xpath("//a[@class = 'enter']");
    private static final By INPUT_LOGIN_USERNAME = By.xpath("//input[@name = 'login']");
    private static final By INPUT_LOGIN_PASSWORD = By.xpath("//input[@name = 'password']");
    private static final By BUTTON_LOGIN_SUBMIT = By.xpath("//input[@class = 'button auth__enter']");
    private static final By LABEL_LOGGED_USER_NAME = By.xpath("//span[@class = 'uname']");
    private static final By LABEL_BUTTON_LOGOUT = By.xpath("//a[@class = 'enter']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open() {
        driver.get(URL);
    }

    private WebElement loginMenuItem() {
        WebElement loginMenuItem = driver.findElement(LOGIN_MENU_ITEM);
        return loginMenuItem;
    }

    private void enterLoginUsername(String loginUsername) {
        WebElement inputLoginUsername = driver.findElement(INPUT_LOGIN_USERNAME);
        inputLoginUsername.sendKeys(loginUsername);
    }

    private void enterLoginPassword(String password) {
        WebElement inputLoginPassword = driver.findElement(INPUT_LOGIN_PASSWORD);
        inputLoginPassword.sendKeys(password);
    }

    private WebElement buttonLoginSubmit() {
        WebElement buttonLoginSubmit = driver.findElement(BUTTON_LOGIN_SUBMIT);
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

    public String getTextOfLabelLoggedOut() {
        String getTextOfLabelLoggedOut = driver.findElement(LABEL_BUTTON_LOGOUT).getText();
        return getTextOfLabelLoggedOut;
    }
}