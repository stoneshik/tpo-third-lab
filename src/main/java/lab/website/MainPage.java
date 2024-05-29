package lab.website;

import lab.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[1]/div[1]/header/h1")
        ).getText();
    }

    public String getTitleForPageWithFilters() {
        return Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[1]/div/header/h1")
        ).getText();
    }

    public void doSearch() {
        WebElement searchButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[1]/div[1]/form/div[5]/button")
        );
        Utils.click(driver, searchButton);
        Utils.wait(driver, 5);
        WebElement carAudioLabel = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div[1]/div/form/div[7]/label[1]")
        );
        Utils.clickAndScroll(driver, carAudioLabel);
        Utils.wait(driver, 30);
        WebElement searchButtonSecond = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div[1]/div/form/div[8]/button")
        );
        Utils.click(driver, searchButtonSecond);
        Utils.wait(driver, 5);
    }

    public void doLogout() {
        WebElement settingsButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/header/div/div/div/button[2]/div")
        );
        Utils.click(driver, settingsButton);
        Utils.wait(driver, 5);
        WebElement exitButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/header/div/div/div/div[1]/form")
        );
        Utils.click(driver, exitButton);
    }

    public void goToPostPage() {
        WebElement searchButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[1]/div[1]/form/div[5]/button")
        );
        Utils.click(driver, searchButton);
        Utils.wait(driver, 10);
        WebElement openPost = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/a")
        );
        Utils.clickAndScroll(driver, openPost);
    }

    public boolean addLike() {
        WebElement searchButton = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[1]/div[1]/form/div[5]/button")
        );
        Utils.click(driver, searchButton);
        Utils.wait(driver, 10);
        WebElement addToFavouritesButton = Utils.getElementByXpath(
            driver,
            By.xpath(
                "/html/body/main/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[4]/div/like-button"
            )
        );
        String countBefore = addToFavouritesButton.getAttribute("count");
        Utils.clickAndScroll(driver, addToFavouritesButton);
        Utils.wait(driver, 10);
        addToFavouritesButton = Utils.getElementByXpath(
            driver,
            By.xpath(
                "/html/body/main/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[4]/div/like-button"
            )
        );
        String count = addToFavouritesButton.getAttribute("count");
        if (countBefore == null) {
            return count == null || count.equals("1");
        }
        return Integer.parseInt(countBefore) != Integer.parseInt(count);
    }
}
