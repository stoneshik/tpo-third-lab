import lab.SeleniumManager;
import lab.Utils;
import lab.website.LoginPage;
import lab.website.MainPage;
import lab.website.UnauthorizedMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    private final SeleniumManager seleniumManager = new SeleniumManager();

    @BeforeEach
    public void prepareDrivers() {
        seleniumManager.prepareDrivers();
    }

    @AfterEach
    public void closeDrivers() {
        seleniumManager.closeDrivers();
    }

    @Test
    public void searchTest() {
        List<WebDriver> drivers = seleniumManager.getDrivers();
        drivers.forEach(
            webDriver -> {
                UnauthorizedMainPage unauthorizedMainPage = new UnauthorizedMainPage(webDriver);
                LoginPage loginPage = new LoginPage(webDriver);
                MainPage mainPage = new MainPage(webDriver);
                webDriver.get(Utils.BASE_URL);
                unauthorizedMainPage.goToLoginPage();
                loginPage.doCorrectLogin();
                Utils.wait(webDriver, 15);
                mainPage.doSearch();
                String title = mainPage.getTitle();
                assertEquals("Acura CL", title);
            }
        );
    }
}
