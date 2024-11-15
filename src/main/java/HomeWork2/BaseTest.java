package HomeWork2;

import Helpers.HomeWorkProperties;
import Helpers.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static Helpers.Properties.homeWorkProperties;

public class BaseTest {
    protected static WebDriver chromeDriver;
    protected WebDriverWait wait;

    @BeforeEach
    public void before(){
        System.setProperty("webdriver.chrome.driver", homeWorkProperties.chromeDriverOrigin());
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }
    @AfterEach
    public void after(){
//        chromeDriver.quit();
    }
    protected static WebDriver getChromeDriver(){
        return chromeDriver;
    }
}
