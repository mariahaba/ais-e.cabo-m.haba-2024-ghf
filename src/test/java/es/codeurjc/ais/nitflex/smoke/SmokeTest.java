package es.codeurjc.ais.nitflex.smoke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SmokeTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testWelcomeMessage() {
        String host = System.getProperty("host");
        if (host == null) {
            throw new IllegalStateException("Host URL must be provided.");
        }

        driver.get(host);

        String welcomeMessage = driver.findElement(By.className("ui header")).getText();
        assertEquals("Welcome to Nitflex", welcomeMessage, "Welcome message is not correct");
    }
}
