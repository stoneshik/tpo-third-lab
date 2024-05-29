package lab.website;

import lab.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostPage extends Page {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return Utils.getElementByXpath(
            driver,
            By.xpath("//h1")
        ).getText();
    }
}
