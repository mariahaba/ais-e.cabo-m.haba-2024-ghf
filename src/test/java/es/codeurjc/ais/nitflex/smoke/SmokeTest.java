package es.codeurjc.ais.nitflex.smoke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SmokeTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testWelcomeMessage() {
        String host = System.getProperty("host");
        if (host == null) {
            throw new IllegalStateException("Host URL must be provided.");
        }

        driver.get(host);

        String welcomeMessage = driver.findElement(By.id("welcomeMessage")).getText();
        assertEquals("Welcome to Nitflex!", welcomeMessage, "Welcome message is not correct");
    }
}
