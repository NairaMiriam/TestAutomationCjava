package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GooglePage;

public class GoogleStepDefinition {

    GooglePage googlePage = new GooglePage();
    String pathBase = System.getProperty("user.dir");
    String pathDriver = pathBase + "\\src\\test\\resources\\driver\\chromedriver.exe";

    @Given("^carga la pagina web de google$")
    public void cargaLaPaginaWebDeGoogle() {
        System.setProperty("webdriver.chrome.driver", pathDriver);
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
        System.setProperty("webdriver.chrome.driver", pathDriver);
        googlePage.driver = new ChromeDriver();
        googlePage.driver.manage().window().maximize();
        googlePage.driver.get("https://www.rentalcars.com/us/airport-rentals/\n");
    }

    @When("^seleciona el pais \"([^\"]*)\"$")
    public void selecionaElPais(String sPais) throws Throwable {
        googlePage.seleccionarPais(sPais);
    }
}
