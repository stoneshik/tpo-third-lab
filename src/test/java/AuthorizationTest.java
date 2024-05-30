import lab.SeleniumManager;
import lab.Utils;
import lab.website.LoginPage;
import lab.website.MainPage;
import lab.website.UnauthorizedMainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationTest {
    private final SeleniumManager seleniumManager = new SeleniumManager();

    @BeforeEach
    public void prepareDrivers() {
        seleniumManager.prepareDrivers();
    }

    @Test
    public void correctLoginTest() {
        List<WebDriver> drivers = seleniumManager.getDrivers();
        drivers.forEach(
            webDriver -> {
                UnauthorizedMainPage unauthorizedMainPage = new UnauthorizedMainPage(webDriver);
                LoginPage loginPage = new LoginPage(webDriver);
                MainPage mainPage = new MainPage(webDriver);
                webDriver.get(Utils.BASE_URL);
                unauthorizedMainPage.goToLoginPage();
                loginPage.doCorrectLogin();
                String title = mainPage.getTitle();
                assertEquals("Лента", title);
                webDriver.quit();
            }
        );
    }

    @Test
    public void incorrectLoginTest() {
        List<WebDriver> drivers = seleniumManager.getDrivers();
        drivers.forEach(
            webDriver -> {
                UnauthorizedMainPage unauthorizedMainPage = new UnauthorizedMainPage(webDriver);
                LoginPage loginPage = new LoginPage(webDriver);
                webDriver.get(Utils.BASE_URL);
                unauthorizedMainPage.goToLoginPage();
                loginPage.doIncorrectLogin();
                String errorMessage = Utils.getElementByXpath(
                    webDriver,
                    By.xpath("//*[@id=\"loginForm\"]/div[2]/span")
                ).getText();
                assertEquals("Указан неверный логин или пароль", errorMessage);
                webDriver.quit();
            }
        );
    }

    @Test
    public void logoutTest() {
        List<WebDriver> drivers = seleniumManager.getDrivers();
        drivers.forEach(
            webDriver -> {
                UnauthorizedMainPage unauthorizedMainPage = new UnauthorizedMainPage(webDriver);
                LoginPage loginPage = new LoginPage(webDriver);
                MainPage mainPage = new MainPage(webDriver);
                webDriver.get(Utils.BASE_URL);
                unauthorizedMainPage.goToLoginPage();
                loginPage.doCorrectLogin();
                mainPage.doLogout();
                webDriver.quit();
            }
        );
    }
}
