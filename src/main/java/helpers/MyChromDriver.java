package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static helpers.HomeWorkProperties.homeWorkProperties;

public class MyChromDriver {
    private static MyChromDriver INSTANCE = null;
    private WebDriver chromeDriver;

    public static WebDriver getDriver() {
        return getInstance().produceDriver();
    }

    public void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", homeWorkProperties.chromeDriverOrigin());
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    private static MyChromDriver getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MyChromDriver();
        }
        return INSTANCE;
    }
    private WebDriver produceDriver(){
        if(chromeDriver == null){
            initChromeDriver();
        }
        return chromeDriver;

    }
}
