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
	// jgvljv
	@LocalServerPort
    int port;

    private WebDriver driver;

    @BeforeEach
public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless"); // Ejecutar sin interfaz gráfica
    options.addArguments("--no-sandbox"); // Ejecutar sin sandbox para evitar problemas de permisos
    options.addArguments("--disable-dev-shm-usage"); // Evitar problemas con el espacio de memoria limitado en docker
    options.addArguments("--disable-gpu"); // Desactivar GPU, no necesaria en modo headless
    options.addArguments("--remote-debugging-port=9222"); // Para depuración remota si es necesario

    driver = new ChromeDriver(options);
}

    @Test
    public void testWelcomeMessage() {
        String host = System.getProperty("host");
        if (host == null) {
            throw new IllegalStateException("Host URL must be provided.");
        }
        host = host + +this.port+"/";
        driver.get(host);
        String welcomeMessage = driver.findElement(By.className("ui header")).getText();
        assertEquals("Welcome to Nitflex", welcomeMessage, "Welcome message is not correct");
    }
}
