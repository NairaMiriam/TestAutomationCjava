package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void buscarCurso(){
        WebElement txtEnterBuscar=driver.findElement(By.className("open_search_overlay"));
        WebElement txtEnterXpath=driver.findElement(By.xpath("//div[@class='search_header']/input"));
        txtEnterXpath.click();
        WebElement txtCurso= driver.findElement(By.id("search-input"));
        txtCurso.clear();
        txtCurso.sendKeys("Java");
        txtCurso.sendKeys(Keys.ENTER);
    }
    public static void main(String[] args) {
        TestEdu testEdu= new TestEdu();
        testEdu.invocarNavegador();
        testEdu.buscarCurso();
    }
}
