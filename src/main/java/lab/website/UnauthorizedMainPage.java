package lab.website;

import lab.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnauthorizedMainPage extends Page {
    public UnauthorizedMainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        WebElement loginButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/header/div/div/div/div[3]/a[1]")
        );
        Utils.click(driver, loginButton);
    }
}