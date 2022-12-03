import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TrianguloSteps {

    private WebDriver driver;

    @Given("estou na funcionalidade de calculo de area")
    public void instanciarSeleniumWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(String.valueOf(SeleniumTest.class.getResource("/webapp/area.html")));
    }

    @When("seleciono o tipo de area do $tipoDeArea")
    public void selecionarTipoTriangulo(String tipoDeArea) {
        if (tipoDeArea.equals("retangulo")) {
            System.out.println("retangulo");
            WebElement areaSelect = driver.findElement(By.id("tipoAreaSelect"));
            Select select = new Select(areaSelect);
            select.selectByIndex(1);
        } else if (tipoDeArea.equals("triangulo")) {
            System.out.println("Triangulo");
            WebElement areaSelect = driver.findElement(By.id("tipoAreaSelect"));
            Select select = new Select(areaSelect);
            select.selectByIndex(2);
        }
    }

    @When("informo para base $base")
    public void informarBase(String baseNumber) {
        WebElement base = driver.findElement(By.id("base"));
        base.sendKeys(baseNumber);
    }

    @When("informo para altura $altura")
    public void informarAltura(String alturaNumber) {
        WebElement altura = driver.findElement(By.id("altura"));
        altura.sendKeys(alturaNumber);
    }

    @When("solicito que o calculo seja realizado")
    public void solicitoQueCalcule() {
        WebElement calcularBtn = driver.findElement(By.id("calcularBtn"));
        calcularBtn.sendKeys(Keys.ENTER);
    }

    @Then("a area calculada sera $areaCalculada")
    public void verificarAreaCalculada(String areaCalculada) {
        WebElement area = driver.findElement(By.id("area"));
        Assertions.assertEquals(areaCalculada, area.getAttribute("value"));
        driver.quit();
    }

}
