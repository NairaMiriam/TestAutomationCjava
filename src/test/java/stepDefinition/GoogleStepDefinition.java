package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import page.GooglePage;

import static parameters.Parameters.*;

import java.io.IOException;

public class GoogleStepDefinition {

    @Autowired
    GooglePage googlePage;

    private EnvironmentVariables env;

    @Given("^carga la pagina web de google$")
    public void cargaLaPaginaWebDeGoogle() {
        System.setProperty("webdriver.chrome.driver", filePathChrome);
        googlePage.driver = new ChromeDriver();
        googlePage.driver.manage().window().maximize();
        googlePage.driver.get("http://google.com/");
    }

    @When("^ingresa el texto \"([^\"]*)\" a buscar$")
    public void ingresaElTextoABuscar(String arg0) throws Throwable {


        googlePage.ingresarTexto(arg0);
    }

    @Then("^la aplicacion web de google realiza la busqueda del texto \"([^\"]*)\"$")
    public void laAplicacionWebDeGoogleRealizaLaBusquedaDelTexto(String arg0) throws Throwable {
        Assert.assertTrue("No se encontro el texto", googlePage.validarTexto(arg0));
    }


    //AirPort

    @Given("^carga la pagina web de AirPort$")
    public void cargaLaPaginaWebDeAirPort() {
        System.setProperty("webdriver.chrome.driver", filePathChrome);
        googlePage.driver = new ChromeDriver();
        googlePage.driver.manage().window().maximize();
        googlePage.driver.get("https://www.rentalcars.com/us/airport-rentals/\n");
    }

    @When("^seleciona el pais \"([^\"]*)\"$")
    public void selecionaElPais(String sPais) throws Throwable {
        googlePage.seleccionarPais(sPais);
    }

    @When("^seleciona pais$")
    public void selecionaPais() throws IOException {
        googlePage.seleccionarPaisExcel();

    }

    @And("^Obtengo la información de sus ciudades$")
    public void obtengoLaInformaciónDeSusCiudades() throws IOException {
        googlePage.obtenerCiudades();
    }
}
