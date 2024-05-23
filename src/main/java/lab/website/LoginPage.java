package lab.website;

import lab.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void doCorrectLogin() {
        tryLogin(Utils.CORRECT_EMAIL, Utils.CORRECT_PASSWORD);
    }

    public void doIncorrectLogin() {
        tryLogin(Utils.CORRECT_EMAIL, Utils.INCORRECT_PASSWORD);
    }

    public void doLogout() {
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/header/div/div/div/button[2]/div")
        ).click();
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/header/div/div/div/div[1]/form/button")
        ).click();
        Utils.waitUntilPageLoads(driver, 10);
    }

    private void tryLogin(CharSequence email, CharSequence password) {
        WebElement emailInput = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"loginForm\"]/div[1]/input")
        );
        WebElement passwordInput = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"loginForm\"]/div[2]/div/input")
        );
        WebElement authButton = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"loginForm\"]/div[4]/div/div[1]/button")
        );
        emailInput.clear();
        passwordInput.clear();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        authButton.click();
    }
}
