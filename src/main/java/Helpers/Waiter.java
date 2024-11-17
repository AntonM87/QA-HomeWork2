package Helpers;

import HomeWork2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Helpers.Properties.homeWorkProperties;

public class Waiter extends BaseTest {
    protected static WebDriverWait wait = new WebDriverWait(BaseTest.chromeDriver, homeWorkProperties.timeOutsSeconds());

    public static WebElement isClickableWait(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
    }
}
