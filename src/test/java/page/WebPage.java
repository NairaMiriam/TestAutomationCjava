package page;

import generic.WebDriverDOM;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("url.base.api.Autoflex")
public class WebPage extends WebDriverDOM {
    @FindBy(name = "q")
    private WebElement txtBuscar1;

    public void ingresarTexto(String sTexto) {
        waitElementVisible(txtBuscar1, 10);
        if (txtBuscar1.isEnabled()) {
            txtBuscar1.clear();
            txtBuscar1.sendKeys(sTexto);
        }
    }
}
