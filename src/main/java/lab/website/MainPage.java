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
            By.xpath("/html/body/main/div/div[2]/div[1]/div/header/h1")
        ).getText();
    }

    public void doSearch() {
        WebElement searchButton = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"experience\"]/div[5]/button")
        );
        applyFilters();
        searchButton.click();
    }

    public String goToPostPage() {
        WebElement expandPost = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[4]/button")
        );
        WebElement openPost = Utils.getElementByXpath(
            driver,
            By.xpath("/html/body/main/div/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/div/div[3]/div[2]/a")
        );
        expandPost.click();
        openPost.click();
        return openPost.getText();
    }

    private void applyFilters() {
        WebElement carBrandField = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"BrandName\"]")
        );
        WebElement carBrandOption = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"BrandName\"]/option[2]")
        );
        WebElement carModelField = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"experience\"]/div[2]/select")
        );
        WebElement carModelOption = Utils.getElementByXpath(
            driver,
            By.xpath("//*[@id=\"experience\"]/div[2]/select/option[2]")
        );
        carBrandField.click();
        carBrandOption.click();
        carModelField.click();
        carModelOption.click();
    }
}
