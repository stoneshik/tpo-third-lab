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

    public void doSearch() {
        WebElement searchButton = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"experience\"]/div[5]/button")
        );
        applyFilters();
        Utils.click(driver, searchButton);
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

    public String goToPostPage() {
        /*
        WebElement expandPost = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[4]/button")
        );
        Utils.click(driver, expandPost);
        Utils.wait(driver, 5);
        WebElement openPost = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[3]/div[2]/a")
        );
        Utils.click(driver, openPost);*/
        WebElement openPost = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[1]/div[3]/div[3]/div/div[1]/a")
        );
        Utils.scroll(driver, openPost);
        Utils.click(driver, openPost);
        return openPost.getText();
    }

    private void applyFilters() {
        WebElement carBrandField = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[1]/div[1]/form/div[1]")
        );
        Utils.click(driver, carBrandField);
        Utils.wait(driver, 5);
        WebElement carBrandOption = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div/div[2]/div[1]/div[1]/form/div[1]/select/option[2]")
        );
        Utils.scroll(driver, carBrandOption);
        Utils.click(driver, carBrandOption);
        Utils.wait(driver, 5);
        WebElement carModelField = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"experience\"]/div[2]/select")
        );
        Utils.click(driver, carModelField);
        Utils.wait(driver, 5);
        WebElement carModelOption = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"experience\"]/div[2]/select/option[2]")
        );
        Utils.click(driver, carModelOption);
    }
}
