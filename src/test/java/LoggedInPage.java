import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage extends PageBasis {
    private static final By LINK_LOGOUT_MENU_ITEM = By.xpath("//a[@class = 'enter logedin']");
    private static final By BUTTON_LOGOUT = By.xpath("//a[@class = 'button wide auth__reg']");
    private static final By LABEL_BUTTON_LOGOUT = By.xpath("//a[@class = 'enter']");

    public LoggedInPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    private WebElement linkLogoutMenuItem() {
        WebElement linkLogoutMenuItem = driver.findElement(LINK_LOGOUT_MENU_ITEM);
        return linkLogoutMenuItem;
    }

    private WebElement buttonLogout() {
        WebElement buttonLogout = driver.findElement(BUTTON_LOGOUT);
        return buttonLogout;
    }
    public void logout(){
        linkLogoutMenuItem().click();
        buttonLogout().click();
    }

    public String getTextOfLabelLoggedOut() {
        String getTextOfLabelLoggedOut = driver.findElement(LABEL_BUTTON_LOGOUT).getText();
        return getTextOfLabelLoggedOut;
    }
}