package es.codeurjc.ais.nitflex.e2e.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import es.codeurjc.ais.nitflex.Application;


@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CancelButtonTest {

    @LocalServerPort
    int port;

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void testCancelButton() {
        // Asegúrate de que la URL sea correcta para tu entorno de prueba
        driver.get("http://localhost:" + port + "/editFilmPage");

        WebElement cancelButton = driver.findElement(By.cssSelector("button.ui.button"));
        cancelButton.click();
        
        // Espera para que la redirección se complete y verifica que la URL sea la de inicio
        assertEquals("http://localhost:" + port + "/", driver.getCurrentUrl(), "The cancel button did not redirect to the home page as expected.");
    }
}
