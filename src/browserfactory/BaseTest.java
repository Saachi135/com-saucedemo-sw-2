package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;
    //public static string baseUrl

    public void openBrowser(String baseUrl) {
        //launch chromeDriver
        driver = new ChromeDriver();
        //open url
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        // close all the browser window
        driver.quit();
    }
}
