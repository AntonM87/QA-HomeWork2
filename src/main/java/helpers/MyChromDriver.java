package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static helpers.HomeWorkProperties.homeWorkProperties;

public class MyChromDriver {
    protected WebDriver chromeDriver;

    public MyChromDriver() {
        System.setProperty("webdriver.chrome.driver", homeWorkProperties.chromeDriverOrigin());
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }
}
