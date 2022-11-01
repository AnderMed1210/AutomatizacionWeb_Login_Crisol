package com.nttdata.stepsdefinitions;

import com.nttdata.steps.HomeCrisolSteps;
import com.nttdata.steps.LoginCrisolSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrisolSD {

    private WebDriver driver;
    private Scenario scenario;

    private HomeCrisolSteps homeCrisolSteps(WebDriver driver){
        return new HomeCrisolSteps(driver);
    }

    private LoginCrisolSteps loginCrisolSteps;

    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    /*------------------------------------------------------*/

    @Given("que estoy en la web de Crisol")
    public void queEstoyEnLaWebDeCrisol() {
        loginCrisolSteps = new LoginCrisolSteps(driver);
        driver.get("https://www.crisol.com.pe/customer/account/login");
        screenShot();
    }

    @When("ingreso con el correo {string}")
    public void ingresoConElCorreo(String correo) {
        loginCrisolSteps.escribirCorreo(correo);
        screenShot();
    }

    @And("ingreso con el password {string}")
    public void ingresoConElPassword(String pass) {
        loginCrisolSteps.escribirPass(pass);
        screenShot();
    }

    @And("clic en el boton Iniciar Sesion")
    public void clicEnElBotonIniciarSesion() {
        loginCrisolSteps.clicIniciarSesion();
        screenShot();
    }

    @Then("validar el saludo {string}")
    public void validarElsaludo(String saludo) {
        String titulo = homeCrisolSteps(driver).getSaludo();
        screenShot();
        Assertions.assertEquals(saludo, titulo);
    }


    @And("validar el telefono de la dirrecion {string}")
    public void validarElTelefonoDeLaDirrecion(String telefono) {
        String titulo = homeCrisolSteps(driver).getTelefono();
        screenShot();
        Assertions.assertEquals(telefono, titulo);
    }

}
