import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage extends PageBasis {
    public LoggedInPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class = 'enter logedin']")
    private WebElement linkLogoutMenuItem;

    private WebElement linkLogoutMenuItem() {
        return linkLogoutMenuItem;
    }

    @FindBy(xpath = "//a[@class = 'button wide auth__reg']")
    private WebElement buttonLogout;

    private WebElement buttonLogout() {
        return buttonLogout;
    }
    public LoginPage logout(){
        linkLogoutMenuItem().click();
        buttonLogout().click();
        return new LoginPage(driver, wait);
    }

    @FindBy(xpath = "//span[@class = 'uname']")
    private WebElement labelLoggedUserName;

    public String getTextOfLabelLoggedUsername() {
        String getTextOfLabelLoggedUsername = labelLoggedUserName.getText();
        return getTextOfLabelLoggedUsername;
    }
}