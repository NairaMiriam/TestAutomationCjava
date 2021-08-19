package lib;

import generic.WebDriverDOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static parameters.Parameters.*;

public class WebDriverManager extends WebDriverDOM {

    public static WebDriver inicializarBrowser() {

        System.setProperty("webdriver.chrome.driver", filePath);
        ChromeOptions options = new ChromeOptions();
        //options.setExperimentalOption("prefs")
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
