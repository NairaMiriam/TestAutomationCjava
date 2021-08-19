package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.WebDriverManager;
import org.junit.Assert;
import page.WebPage;

public class WebStepDefinitio {
    WebPage webPage = new WebPage();

    @Given("^carga la pagina web de google _01$")
    public void cargaLaPaginaWebDeGoogle() {
        webPage.setDriver(WebDriverManager.inicializarBrowser());
        webPage.open();
        Assert.assertEquals("Google", webPage.getTitle());

    }

    @When("^ingresa el texto \"([^\"]*)\" a buscar _01$")
    public void ingresaElTextoABuscar(String arg0) throws Throwable {

    }

    @Then("^la aplicacion web de google realiza la busqueda del texto \"([^\"]*)\" _01$")
    public void laAplicacionWebDeGoogleRealizaLaBusquedaDelTexto(String arg0) throws Throwable {

    }
}
