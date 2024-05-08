package es.codeurjc.ais.nitflex.smoke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import es.codeurjc.ais.nitflex.Application;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeTest {
	
	@LocalServerPort
    int port;

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testWelcomeMessage() {
        // Obtiene la URL de la aplicación desplegada desde las propiedades del sistema
        String host = System.getProperty("host");
        if (host == null) {
            throw new IllegalStateException("Host URL must be provided.");
        }
        host = host + +this.port+"/";

        // Navega a la URL de la aplicación
        driver.get(host);

        // Encuentra el elemento que contiene el mensaje de bienvenida y verifica su contenido
        String welcomeMessage = driver.findElement(By.className("ui header")).getText();
        assertEquals("Welcome to Nitflex", welcomeMessage, "Welcome message is not correct");
    }
}
