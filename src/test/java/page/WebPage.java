package page;

import static parameters.Parameters.*;

import cucumber.api.Scenario;
import generic.TomarCaptura;
import generic.WebDriverDOM;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

@DefaultUrl("page:url.prueba")
public class WebPage extends WebDriverDOM {
    TomarCaptura tomarCaptura = new TomarCaptura();
    @FindBy(name = "q")
    private WebElement txtBuscar1;


    public void ingresarTexto(String sTexto) {


        waitElementVisible(txtBuscar1, 10);
        if (txtBuscar1.isEnabled()) {
            txtBuscar1.clear();
            txtBuscar1.sendKeys(sTexto);
        }
    }

    public void tomarCaptura(String nombreCaptura) throws IOException {
        String nombre = filePathScreen + nombreCaptura + ".png";
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(nombre));
    }

    @After
    public void captura(Scenario scenario) {
        TomarCaptura.captura(getDriver(), scenario);
    }
}
