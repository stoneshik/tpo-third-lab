package lab.website;

import lab.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class PostPage extends Page {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/header/h1")
        ).getText();
    }

    public void goToEarlier() {
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[5]/div/a[1]")
        ).click();
    }

    public void goToFurther() {
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[5]/div/a[2]")
        ).click();
    }

    public boolean addToFavourites() {
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
        ).click();
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/div[7]/div/div[2]/form/div[3]/button")
        ).click();
        return Objects.equals(
            Utils.getElementByXpath(
                driver,
                By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
            ).getAttribute("data-tt"),
            "Удалить из избранного"
        );
    }

    public boolean removeFromFavourites() {
        Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
        ).click();
        return Objects.equals(
            Utils.getElementByXpath(
                driver,
                By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
            ).getAttribute("data-tt"),
            "Добавить в избранное"
        );
    }
}
