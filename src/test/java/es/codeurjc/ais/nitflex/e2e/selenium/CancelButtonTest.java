import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class CancelButtonTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Asegúrate de que el path al ChromeDriver es correcto y que corresponde con tu configuración
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        // Ajusta la URL al entorno de prueba donde el formulario de edición está disponible
        driver.get("http://localhost:8080/editfilm"); // Cambia esto a la URL donde se encuentra el botón Cancel
    }

    @Test
    public void testCancelButtonRedirectsToHomePage() {
        // Asegúrate de que este selector encuentra el botón Cancel
        driver.findElement(By.cssSelector("button.ui.button")).click();
        // Verifica que la URL actual es la página de inicio (ajusta según la configuración de tu aplicación)
        assertEquals("http://localhost:8080/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
