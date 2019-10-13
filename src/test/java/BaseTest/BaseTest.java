package BaseTest;

import Utilities.LocalDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    public void beforeMethod(String browser, String url){
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--disable-notifications");
                driver = new ChromeDriver(ops);
                break;
            case "ff":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().arch32().setup();
                driver = new InternetExplorerDriver();
                break;
        }
        LocalDriverManager.setWebDriver(driver);
        driver = LocalDriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
        System.out.println("Browser name : " + browser);
        System.out.println("Navigating to : " + url);
    }

    public void afterMethod(){
        LocalDriverManager.getDriver().quit();
    }
}
