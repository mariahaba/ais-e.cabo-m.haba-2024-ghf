import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SmokeTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Espera implícita de 10 segundos
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
            fail("Host URL must be provided.");
        }
        host += this.port + "/";
        
        driver.get(host);
        
        WebElement header = driver.findElement(By.className("ui header"));
        String welcomeMessage = header.getText();
        assertEquals("Welcome to Nitflex", welcomeMessage, "Welcome message is not correct");
    }
}
