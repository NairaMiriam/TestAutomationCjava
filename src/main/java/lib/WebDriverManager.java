package lib;

import generic.WebDriverDOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

import static parameters.Parameters.*;

public class WebDriverManager extends WebDriverDOM {

    public static WebDriver inicializarBrowser() {

        System.setProperty("webdriver.chrome.driver", filePathChrome);
        ChromeOptions options = new ChromeOptions();
        //options.setExperimentalOption("prefs")
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        return webDriver;
    }


    public static WebDriver inicializarBrowser(String browser) {

        String BASE_PATH = System.getProperty("user.dir");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        WebDriver webDriver;

        if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("background")) {

            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", BASE_PATH + "\\descargas\\");
            ChromeOptions options = new ChromeOptions();

            if (browser.equalsIgnoreCase("background")) {
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-extensions");
                options.addArguments("--start-maximized");


                options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");

                System.out.println("Modo Background: SI");
            } else {
                System.out.println("Modo Background: NO");
            }
            //Si es win o linux
            if (System.getProperty("os.name").contains("Mac") || System.getProperty("os.name").contains("Linux")) {
                System.out.println("No se puede por ambiente");
            } else {
                BASE_PATH = BASE_PATH + "/src/main/resources/drivers/win/chromedriver.exe";
                options.setExperimentalOption("prefs", chromePrefs);
                options.setExperimentalOption("useAutomationExtension", false);
            }
            System.setProperty("webdriver.chrome.driver", filePathChrome);
            webDriver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", filePathFirefox);
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Tipo de navegador no soportado: " + browser);
        }
        webDriver.manage().window().maximize();
        return webDriver;
    }


}
