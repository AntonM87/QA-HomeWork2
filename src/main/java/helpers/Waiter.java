package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private WebDriverWait wait;
    public Waiter(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement isClickableWait(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
