package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.yecht.Data;
import util.ReadExcelFile;
import util.WriteExcelFile;

import java.io.IOException;
import java.util.List;

public class GooglePage {
    public WebDriver driver;
    ReadExcelFile readExcelFile = new ReadExcelFile();
    WriteExcelFile writeExcelFile = new WriteExcelFile();
    String filePath = "src/test/resources/file/Test.xlsx";
    @FindBy(name = "q")
    private WebElement txtBuscar1;

    public void ingresarTexto(String sTexto) {
        WebElement txtBuscar = driver.findElement(By.name("q"));
        waitElementVisible(txtBuscar, 10);
        txtBuscar.clear();
        txtBuscar.sendKeys(sTexto);
        txtBuscar.submit();

    }

    public boolean validarTexto(String sTexto) {
        //WebElement txtEncontrado = driver.findElement(By.xpath("//div[@class='PyJv1b gsmt PZPZlf']/span"));
        //waitElementVisible(txtEncontrado, 10);
        //System.out.println(txtEncontrado.getText() + "\n");
        if (driver.getTitle().contains(sTexto)) {
            return true;
        }
        return false;
    }

    public void seleccionarPais(String sPais) {
        WebElement pais = driver.findElement(By.id("pu-country"));
        waitElementVisible(pais, 10);
        // pais.click();
        List<WebElement> listPais = driver.findElements(By.xpath("//option"));
        System.out.println(listPais.size());
        System.out.println(listPais.get(2).getText());
        for (int i = 0; i < listPais.size(); i++) {
            if (listPais.get(i).getText().contains(sPais)) {
                listPais.get(i).click();
                break;
            }
        }
    }

    public void seleccionarPaisExcel() throws IOException {
        String paisNombre = readExcelFile.readCellValue(filePath, "Test", 0, 0);
        System.out.println("Pais obtenido : " + paisNombre);
        WebElement pais = driver.findElement(By.id("pu-country"));
        waitElementVisible(pais, 10);
        // pais.click();
        List<WebElement> listPais = driver.findElements(By.xpath("//option"));
        System.out.println(listPais.size());
        System.out.println(listPais.get(2).getText());
        for (int i = 0; i < listPais.size(); i++) {
            if (listPais.get(i).getText().contains(paisNombre)) {
                listPais.get(i).click();
                break;
            }
        }
    }

    public void obtenerCiudades() throws IOException {
        String ciudadObtenida = "";
        WebElement ciudad = driver.findElement(By.xpath("//select[@id='pu-city']"));
        waitElementVisible(ciudad, 10);
        System.out.println(ciudad.getText());
        List<WebElement> listCiudad = driver.findElements(By.xpath("//option"));
        System.out.println(listCiudad.size());
        System.out.println(listCiudad.get(5).getText());
        for (int i = 0; i < listCiudad.size(); i++) {
            if (listCiudad.get(i).getText().contains("Lima")) {
                ciudadObtenida = listCiudad.get(i).getText();
                listCiudad.get(i).click();
                break;
            }
        }
        writeExcelFile.writeCellValue(filePath, "Test", 0, 1, ciudadObtenida);
    }

    public boolean waitElementVisible(WebElement element, int tiempoSegundos) {
        boolean value = false;
        for (int i = 0; i <= tiempoSegundos; i++) {
            try {
                Thread.sleep(1000);
                value = element.isDisplayed();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return value;
    }
}
