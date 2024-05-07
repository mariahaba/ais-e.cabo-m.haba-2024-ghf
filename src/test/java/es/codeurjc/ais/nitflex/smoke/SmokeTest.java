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
        // Set up the Chrome Driver
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
        // Obtiene la URL de la aplicación desplegada desde las propiedades del sistema
        String host = System.getProperty("host");
        if (host == null) {
            throw new IllegalStateException("Host URL must be provided.");
        }

        // Navega a la URL de la aplicación
        driver.get(host);

        // Encuentra el elemento que contiene el mensaje de bienvenida y verifica su contenido
        String welcomeMessage = driver.findElement(By.id("welcomeMessage")).getText();
        assertEquals("Welcome to Nitflex!", welcomeMessage, "Welcome message is not correct");
    }
}
