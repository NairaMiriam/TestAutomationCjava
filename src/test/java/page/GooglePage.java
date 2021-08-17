package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePage {
    public WebDriver driver;

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

    public void seleccionarPais(String sPais){
        WebElement pais=driver.findElement(By.id("pu-country"));
        waitElementVisible(pais,10);
       // pais.click();
        List<WebElement> listPais=driver.findElements(By.xpath("//option"));
        System.out.println(listPais.size());
        System.out.println(listPais.get(2).getText());
        for (int i = 0; i < listPais.size(); i++) {
            if(listPais.get(i).getText().contains(sPais)){
                listPais.get(i).click();
            }
        }
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
