package lab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static final String BASE_URL = "https://drive2.ru/";
    public static final String CORRECT_EMAIL = "stoneshik@mail.ru";
    public static final String INCORRECT_PASSWORD = "aboba";
    public static final String CORRECT_PASSWORD = "aboba1234";


    public static WebElement getElementByXpath(WebDriver driver, By selector) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void click(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public static void clickAndScroll(WebDriver driver, WebElement element) {
        WebElement myElement = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        ).until(
            ExpectedConditions.visibilityOf(element)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
        click(driver, element);
    }
}
