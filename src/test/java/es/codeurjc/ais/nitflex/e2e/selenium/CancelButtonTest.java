import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CancelButtonTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/editFilmPage"); 
    }

    @Test
    public void testCancelButtonRedirectsToHomePage() {
        driver.findElement(By.cssSelector("button.ui.button")).click();
        assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
