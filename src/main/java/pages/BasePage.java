package pages;

import helpers.MyChromDriver;
import helpers.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    protected final Actions actions;
    protected final Waiter waiter;
    protected final WebDriver chromeDriver;

    public BasePage() {
        chromeDriver = MyChromDriver.getDriver();
        waiter = new Waiter(chromeDriver);
        actions = new Actions(chromeDriver);
    }
}
