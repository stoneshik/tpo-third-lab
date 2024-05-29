package lab;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeleniumManager {
    private final List<WebDriver> drivers;

    public SeleniumManager() {
        drivers = createDrivers();
    }

    public List<WebDriver> getDrivers() {
        return drivers;
    }

    public void prepareDrivers() {
        ChromeDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();
    }

    public void closeDrivers() {
        drivers.forEach(
            webDriver -> {
                Utils.wait(webDriver, 5);
                webDriver.quit();
            }
        );
    }

    private List<WebDriver> createDrivers() {
        List<WebDriver> drivers = new ArrayList<>();
        try {
            List<String> properties = Files.readAllLines(Paths.get("lab.properties"));
            for (String property : properties) {
                if (property.startsWith("WEB_DRIVER")) {
                    switch (property.toLowerCase().split("=")[1]) {
                        case "chrome":
                            createDriver(drivers, getChromeDriver());
                            return drivers;
                        case "firefox":
                            createDriver(drivers, getFirefoxDriver());
                            return drivers;
                        case "both":
                            WebDriver firefoxDriver = getFirefoxDriver();
                            firefoxDriver.manage().window().maximize();
                            WebDriver chromeDriver = getChromeDriver();
                            chromeDriver.manage().window().maximize();
                            drivers.add(chromeDriver);
                            drivers.add(firefoxDriver);
                            return drivers;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Web driver is not specified");
    }

    private void createDriver(List<WebDriver> drivers, WebDriver driver) {
        driver.manage().window().maximize();
        drivers.add(driver);
    }

    private RemoteWebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments(
            "user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
            "--disable-blink-features=AutomationControlled"
        );
        return new ChromeDriver();
    }

    private FirefoxDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(
            "user-agent=Mozilla/5.0 (X11; Linux x86_64; rv:126.0) Gecko/20100101 Firefox/126.0",
            "--disable-blink-features=AutomationControlled"
        );
        return new FirefoxDriver();
    }
}
