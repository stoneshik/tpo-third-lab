package lab.website;

import lab.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        WebElement goToEarlierButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[5]/div/a[1]")
        );
        Utils.click(driver, goToEarlierButton);
    }

    public void goToFurther() {
        WebElement goToFurtherButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[5]/div/a[2]")
        );
        Utils.click(driver, goToFurtherButton);
    }

    public boolean addToFavourites() {
        WebElement addToFavouritesButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
        );
        WebElement saveButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/div[7]/div/div[2]/form/div[3]/button")
        );
        Utils.click(driver, addToFavouritesButton);
        Utils.click(driver, saveButton);
        return Objects.equals(
            Utils.getElementByXpath(
                driver,
                By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
            ).getAttribute("data-tt"),
            "Удалить из избранного"
        );
    }

    public boolean removeFromFavourites() {
        WebElement removeFromFavouritesButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
        );
        Utils.click(driver, removeFromFavouritesButton);
        return Objects.equals(
            Utils.getElementByXpath(
                driver,
                By.xpath("/html/body/main/div/div[2]/div/div[2]/div[3]/div[4]/div[1]/bookmark-button")
            ).getAttribute("data-tt"),
            "Добавить в избранное"
        );
    }
}
