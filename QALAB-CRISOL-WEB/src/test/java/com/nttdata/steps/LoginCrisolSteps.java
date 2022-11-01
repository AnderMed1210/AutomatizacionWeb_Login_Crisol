package com.nttdata.steps;

import com.nttdata.page.LoginCrisolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginCrisolSteps {

    private WebDriver driver;

    //constructor
    public LoginCrisolSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void escribirCorreo(String user){
        WebElement userInputElement = driver.findElement(LoginCrisolPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginCrisolPage.loginButton));
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void escribirPass(String password){
        this.driver.findElement(LoginCrisolPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void clicIniciarSesion(){
        this.driver.findElement(LoginCrisolPage.loginButton).click();
    }


}
