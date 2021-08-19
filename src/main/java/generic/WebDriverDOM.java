package generic;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class WebDriverDOM extends PageObject {


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
