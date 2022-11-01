package com.nttdata.steps;

import com.nttdata.page.HomeCrisolPage;
import com.nttdata.page.LoginCrisolPage;
import org.openqa.selenium.WebDriver;

public class HomeCrisolSteps {

    private WebDriver driver;

    //contrsuctor
    public HomeCrisolSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */

    public String getSaludo(){
        return this.driver.findElement(HomeCrisolPage.saludo).getText();
    }

    public String getTelefono(){
        return this.driver.findElement(HomeCrisolPage.telefono).getText();
    }

    /**
     * Retorna la cantidad de items
     * @return la cantidad de items
     */

}
