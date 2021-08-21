package generic;

import cucumber.api.Scenario;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static parameters.Parameters.*;

public class TomarCaptura {


    public static String getFeature(String id) {
        String[] nombre = id.split(";");
        String outNombre = nombre[0].substring(0, 1) + nombre[0].substring(1);
        return outNombre.replace('-', ' ');
    }

    public static void captura(WebDriver driver, Scenario scenario) {
        File dir = new File(filePathScreen);
        if (!dir.exists()) {
            dir.mkdir();
        } else {
            System.out.println("Directorio ya Existe");
        }

        File scrFile = ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        File Directorio = new File("");

        String nombre = scenario.getId() + " Prueba";
        String nuevoNombre = "";
        try {
            nuevoNombre = Directorio.getCanonicalPath() + File.separator + filePathScreen + File.separator + nombre + ".png";
            FileUtils.copyFile(scrFile, new File(nuevoNombre));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
