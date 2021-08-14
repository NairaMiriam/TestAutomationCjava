package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEdu {
    WebDriver driver;

    String pathBase = System.getProperty("user.dir");
    String pathDriver = pathBase + "\\src\\test\\resources\\driver\\chromedriver.exe";

    public void invocarNavegador() {
        System.setProperty("webdriver.chrome.driver", pathDriver);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.edureka.co/");
        String tituloWeb = driver.getTitle();
        System.out.println(tituloWeb + "\n");
    }
}
