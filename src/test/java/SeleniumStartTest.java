import lab.SeleniumManager;
import lab.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumStartTest {
    private final SeleniumManager seleniumManager = new SeleniumManager();

    @BeforeEach
    public void prepareDrivers() {
        seleniumManager.prepareDrivers();
    }

    @AfterEach
    public void closeDrivers() {
        seleniumManager.closeDrivers();
    }

    @Test
    public void testDriver() {
        seleniumManager.getDrivers().forEach(this::executeWithCapabilities);
    }

    private void executeWithCapabilities(WebDriver driver) {
        driver.get(Utils.BASE_URL);
        String title = driver.getTitle();
        assertEquals("DRIVE2.RU", title);
    }
}
