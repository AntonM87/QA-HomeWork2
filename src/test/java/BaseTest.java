import helpers.MyChromDriver;
import helpers.Waiter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static helpers.HomeWorkProperties.homeWorkProperties;

public class BaseTest {
    protected static WebDriver chromeDriver;
    protected WebDriverWait wait;
    protected Waiter waiter;

    @BeforeEach
    public void before(){
        System.setProperty("webdriver.chrome.driver", homeWorkProperties.chromeDriverOrigin());
        chromeDriver = MyChromDriver.getDriver();
        System.out.println(chromeDriver);
        wait = new WebDriverWait(chromeDriver, 10);
        waiter = new Waiter(chromeDriver);
    }

    @AfterEach
    public void after(){
//        chromeDriver.close();
//        chromeDriver.quit();
    }
//    public static WebDriver getChromeDriver(){
//        return chromeDriver;
//    }
}
