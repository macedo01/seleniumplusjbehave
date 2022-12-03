import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SeleniumTest {

    private WebDriver driver;

    @BeforeAll
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterAll
    void tearDown() {
        driver.quit();
    }


    @Test
    void testeAreaTriangulo() throws InterruptedException {
        driver.get(String.valueOf(SeleniumTest.class.getResource("/webapp/area.html")));
        WebElement areaSelect = driver.findElement(By.id("tipoAreaSelect"));
        Select select = new Select(areaSelect);
        select.selectByIndex(2);
        WebElement base = driver.findElement(By.id("base"));
        base.sendKeys("3");
        WebElement altura = driver.findElement(By.id("altura"));
        altura.sendKeys("4");
        WebElement calcularBtn = driver.findElement(By.id("calcularBtn"));
        calcularBtn.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement area = driver.findElement(By.id("area"));
        Assertions.assertEquals("6",area.getAttribute("value"));
    }

}


