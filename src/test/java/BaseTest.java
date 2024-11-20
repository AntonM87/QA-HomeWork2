import helpers.HomeWorkProperties;
import helpers.MyChromDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static helpers.HomeWorkProperties.homeWorkProperties;

public class BaseTest {
    protected static WebDriver chromeDriver;
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeEach
    public void before(){
        System.setProperty("webdriver.chrome.driver", homeWorkProperties.chromeDriverOrigin());
        chromeDriver = new MyChromDriver().getChromeDriver();
        System.out.println(chromeDriver);

        actions = new Actions(chromeDriver);
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
