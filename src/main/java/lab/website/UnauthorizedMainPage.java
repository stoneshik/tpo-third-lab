package lab.website;

import lab.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UnauthorizedMainPage extends Page {
    public UnauthorizedMainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/header/div/div/div/div[3]/a[1]")
        ).click();
    }
}