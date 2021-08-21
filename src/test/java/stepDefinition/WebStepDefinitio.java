package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.WebDriverManager;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import page.WebPage;

import java.io.IOException;

public class WebStepDefinitio {

    WebPage webPage = new WebPage();
    private static EnvironmentVariables environmentVariables = null;

    @Given("^carga la pagina web de google _web$")
    public void cargaLaPaginaWebDeGoogle() throws IOException {
        webPage.setDriver(WebDriverManager.inicializarBrowser("firefox"));
        webPage.open();
        webPage.tomarCaptura("Paso_01");
        //Assert.assertEquals("Google", webPage.getTitle());

        String value = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("usuario.prueba");
        System.out.println(value);


        String token = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("token");
        System.out.println(token);

    }

    @When("^ingresa el texto \"([^\"]*)\" a buscar _web$")
    public void ingresaElTextoABuscar(String arg0) throws Throwable {
        webPage.ingresarTexto("Hola");
        webPage.tomarCaptura("Ingreso");
    }

    @Then("^la aplicacion web de google realiza la busqueda del texto \"([^\"]*)\" _web$")
    public void laAplicacionWebDeGoogleRealizaLaBusquedaDelTexto(String arg0) throws Throwable {

        webPage.ingresarTexto("Google ");
        webPage.tomarCaptura("google");
    }
}
