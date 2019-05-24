import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogOutTutByTest extends BeforeAfter {
    private static final String LOGIN_USERNAME = "seleniumtests@tut.by";
    private static final String LOGIN_PASSWORD = "123456789zxcvbn";
    private static final String EXPECTED_TEXT_OF_LABEL_LOGGED_OUT = "Войти";

    @Test
    public void logoutSuccessful() {
        LoginPage loginPage = new LoginPage(driver, wait);
        LoggedInPage loggedInPage = loginPage.login(LOGIN_USERNAME, LOGIN_PASSWORD);
        loginPage = loggedInPage.logout();
        assertEquals(EXPECTED_TEXT_OF_LABEL_LOGGED_OUT, loginPage.getTextOfLabelLoggedOut());
    }
}