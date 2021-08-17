import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDefinition {


    @Given("^carga la pagina web de google$")
    public void cargaLaPaginaWebDeGoogle() {
    }

    @When("^ingresa el texto \"([^\"]*)\" a buscar$")
    public void ingresaElTextoABuscar(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^la aplicacion web de google realiza la busqueda del texto \"([^\"]*)\"$")
    public void laAplicacionWebDeGoogleRealizaLaBusquedaDelTexto(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
